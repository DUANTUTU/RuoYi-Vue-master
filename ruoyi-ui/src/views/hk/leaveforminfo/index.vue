<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="请假人员Id" prop="userid">-->
<!--        <el-input-->
<!--          v-model="queryParams.userid"-->
<!--          placeholder="请输入请假人员Id"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="请假起始时间" prop="begintime">
        <el-date-picker clearable
                        v-model="queryParams.begintime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择请假起始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="请假结束时间" prop="finishtime">
        <el-date-picker clearable
                        v-model="queryParams.finishtime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择请假结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="请假原因" prop="reason">
        <el-input
          v-model="queryParams.reason"
          placeholder="请输入请假原因"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="sataus">
        <el-select v-model="queryParams.sataus" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.hk_student_leave"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['hk:leaveforminfo:add']"
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
          v-hasPermi="['hk:leaveforminfo:edit']"
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
          v-hasPermi="['hk:leaveforminfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hk:leaveforminfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="leaveforminfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="请假事务id" align="center" prop="id" />
      <el-table-column label="请假人员学号" align="center" prop="userid" />
      <el-table-column label="请假人员姓名" align="center" prop="name"/>
      <el-table-column label="请假起始时间" align="center" prop="begintime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.begintime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="请假结束时间" align="center" prop="finishtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.finishtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="请假原因" align="center" prop="reason" />
<!--      <el-table-column label="状态" align="center" prop="sataus">-->
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.hk_student_leave" :value="scope.row.sataus" />-->
<!--        </template>-->
<!--        -->
<!--      </el-table-column>-->
      <el-table-column label="状态" align="center" prop="sataus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.hk_student_leave" :value="scope.row.sataus"/>

        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hk:leaveforminfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hk:leaveforminfo:remove']"
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

    <!-- 添加或修改学生请假对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="请假人员Id" prop="userid">
          <el-input v-model="form.userid" placeholder="请输入请假人员Id" />
        </el-form-item>
        <el-form-item label="请假起始时间" prop="begintime">
          <el-date-picker clearable
                          v-model="form.begintime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择请假起始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="请假结束时间" prop="finishtime">
          <el-date-picker clearable
                          v-model="form.finishtime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择请假结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="请假原因" prop="reason">
          <el-input v-model="form.reason" placeholder="请输入请假原因" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.sataus">
            <el-radio
              v-for="dict in dict.type.hk_student_leave"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listLeaveforminfo, getLeaveforminfo, delLeaveforminfo, addLeaveforminfo, updateLeaveforminfo } from "@/api/hk/leaveforminfo";

export default {
  name: "Leaveforminfo",
  dicts: ['hk_student_leave'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 学生请假表格数据
      leaveforminfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userid: null,
        begintime: null,
        finishtime: null,
        reason: null,
        sataus: null
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
  },
  methods: {
    /** 查询学生请假列表 */
    getList() {
      this.loading = true;
      console.log("diaoyong")
      listLeaveforminfo(this.queryParams).then(response => {
        this.leaveforminfoList = response.rows;
        this.total = response.total;
        console.log("diaoyong")
        console.log(response.rows)
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
        id: null,
        userid: null,
        begintime: null,
        finishtime: null,
        reason: null,
        sataus: 0
      };
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学生请假";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLeaveforminfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学生请假";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLeaveforminfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLeaveforminfo(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除学生请假编号为"' + ids + '"的数据项？').then(function() {
        return delLeaveforminfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('hk/leaveforminfo/export', {
        ...this.queryParams
      }, `leaveforminfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
