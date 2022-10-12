import request from '@/utils/request'

// 查询学生宿舍列表
export function listDormitoryInfo(query) {
  return request({
    url: '/hk/dormitoryInfo/list',
    method: 'get',
    params: query
  })
}
export function listStudentInfo(query) {
  return request({
    url: '/hk/dormitoryInfo/Studentlist',
    method: 'get',
    params: query
  })
}
// 查询学生宿舍详细
export function getDormitoryInfo(dormitoryid) {
  return request({
    url: '/hk/dormitoryInfo/' + dormitoryid,
    method: 'get'
  })
}

// 新增学生宿舍
export function addDormitoryInfo(data) {
  return request({
    url: '/hk/dormitoryInfo',
    method: 'post',
    data: data
  })
}

// 修改学生宿舍
export function updateDormitoryInfo(data) {
  return request({
    url: '/hk/dormitoryInfo',
    method: 'put',
    data: data
  })
}

// 删除学生宿舍
export function delDormitoryInfo(dormitoryid) {
  return request({
    url: '/hk/dormitoryInfo/' + dormitoryid,
    method: 'delete'
  })
}
