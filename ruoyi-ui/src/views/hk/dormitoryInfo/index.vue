<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="所归属的班级" prop="classid">
        <el-input
          v-model="queryParams.classid"
          placeholder="请输入所归属的班级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['hk:dormitoryInfo:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['hk:dormitoryInfo:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['hk:dormitoryInfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hk:dormitoryInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" type="expand" :data="dormitoryInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="宿舍号" align="center" prop="dormitoryid" />
      <el-table-column label="所归属的班级" align="center" prop="classid" />
      <el-table-column label="宿舍成员" align="center" prop="name" type="expand" >
        <el-table :data="hkStudentinfoList"@row-click="handleUpdate(scope.row)" ref="hkStudentinfo">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="姓名" prop="name" width="150">
          </el-table-column>
          <el-table-column label="年龄" prop="age" width="150">

          </el-table-column>
          <el-table-column label="性别" prop="sex" width="150">

          </el-table-column>
          <el-table-column label="年级" prop="grade" width="150">

          </el-table-column>
          <el-table-column label="班级id" prop="classid" width="150">

          </el-table-column>
          <el-table-column label="电话" prop="tel" width="150">

          </el-table-column>
          <el-table-column label="学院id" prop="collegeid" width="150">

          </el-table-column>
          <el-table-column label="宿舍id" prop="dormitoryid" width="150">

          </el-table-column>

          <el-table-column label="学号" prop="userid" width="150">

          </el-table-column>
        </el-table>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">

        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hk:dormitoryInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hk:dormitoryInfo:remove']"
          >删除</el-button>
        </template>
      </el-table-column>

    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改学生宿舍对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="所归属的班级" prop="classid">
          <el-input v-model="form.classid" placeholder="请输入所归属的班级" />
        </el-form-item>
        <el-divider content-position="center">住宿学生信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddHkStudentinfo">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteHkStudentinfo">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="hkStudentinfoList" :row-class-name="rowHkStudentinfoIndex" @selection-change="handleHkStudentinfoSelectionChange" ref="hkStudentinfo">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="姓名" prop="name" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.name" placeholder="请输入姓名" />
            </template>
          </el-table-column>
          <el-table-column label="年龄" prop="age" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.age" placeholder="请输入年龄" />
            </template>
          </el-table-column>
          <el-table-column label="性别" prop="sex" width="150">
            <template slot-scope="scope">
              <el-select v-model="scope.row.sex" placeholder="请选择性别">
                <el-option label="请选择字典生成" value="" />
              </el-select>
            </template>
          </el-table-column>
          <el-table-column label="年级" prop="grade" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.grade" placeholder="请输入年级" />
            </template>
          </el-table-column>
          <el-table-column label="班级id" prop="classid" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.classid" placeholder="请输入班级id" />
            </template>
          </el-table-column>
          <el-table-column label="电话" prop="tel" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.tel" placeholder="请输入电话" />
            </template>
          </el-table-column>
          <el-table-column label="学院id" prop="collegeid" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.collegeid" placeholder="请输入学院id" />
            </template>
          </el-table-column>
          <el-table-column label="宿舍id" prop="dormitoryid" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.dormitoryid" placeholder="请输入宿舍id" />
            </template>
          </el-table-column>
          <el-table-column label="学生所处于状态  1正常 0异常" prop="status" width="150">
            <template slot-scope="scope">
              <el-select v-model="scope.row.status" placeholder="请选择学生所处于状态  1正常 0异常">
                <el-option label="请选择字典生成" value="" />
              </el-select>
            </template>
          </el-table-column>
          <el-table-column label="学号" prop="userid" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.userid" placeholder="请输入学号" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDormitoryInfo, listStudentInfo,getDormitoryInfo, delDormitoryInfo, addDormitoryInfo, updateDormitoryInfo } from "@/api/hk/dormitoryInfo";

export default {
  name: "DormitoryInfo",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedHkStudentinfo: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 学生宿舍表格数据
      dormitoryInfoList: [],
      // ${subTable.functionName}表格数据
      hkStudentinfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        classid: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    this.getStudentList();
  },
  methods: {
    /** 查询学生宿舍列表 */
    getList() {
      this.loading = true;
      listDormitoryInfo(this.queryParams).then(response => {
        this.dormitoryInfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getStudentList(){
      this.loading = true;
      listStudentInfo(this.queryParams).then(response => {
        this.hkStudentinfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        dormitoryid: null,
        classid: null
      };
      this.hkStudentinfoList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.dormitoryid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学生宿舍";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      console.log("已经执行");
      this.reset();
      const dormitoryid = row.dormitoryid || this.ids
      getDormitoryInfo(dormitoryid).then(response => {
        this.form = response.data;
        this.hkStudentinfoList = response.data.hkStudentinfoList;
        this.open = true;
        this.title = "修改学生宿舍";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.hkStudentinfoList = this.hkStudentinfoList;
          if (this.form.dormitoryid != null) {
            updateDormitoryInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDormitoryInfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const dormitoryids = row.dormitoryid || this.ids;
      this.$modal.confirm('是否确认删除学生宿舍编号为"' + dormitoryids + '"的数据项？').then(function() {
        return delDormitoryInfo(dormitoryids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** ${subTable.functionName}序号 */
    rowHkStudentinfoIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** ${subTable.functionName}添加按钮操作 */
    handleAddHkStudentinfo() {
      let obj = {};
      obj.name = "";
      obj.age = "";
      obj.sex = "";
      obj.grade = "";
      obj.classid = "";
      obj.tel = "";
      obj.collegeid = "";
      obj.dormitoryid = "";
      obj.status = "";
      obj.userid = "";
      this.hkStudentinfoList.push(obj);
    },
    /** ${subTable.functionName}删除按钮操作 */
    handleDeleteHkStudentinfo() {
      if (this.checkedHkStudentinfo.length == 0) {
        this.$modal.msgError("请先选择要删除的学生数据");
      } else {
        const hkStudentinfoList = this.hkStudentinfoList;
        const checkedHkStudentinfo = this.checkedHkStudentinfo;
        this.hkStudentinfoList = hkStudentinfoList.filter(function(item) {
          return checkedHkStudentinfo.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleHkStudentinfoSelectionChange(selection) {
      this.checkedHkStudentinfo = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('hk/dormitoryInfo/export', {
        ...this.queryParams
      }, `dormitoryInfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
