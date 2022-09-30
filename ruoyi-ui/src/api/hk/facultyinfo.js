import request from '@/utils/request'

// 查询教职工请假信息列表
export function listFacultyinfo(query) {
  return request({
    url: '/hk/facultyinfo/list',
    method: 'get',
    params: query
  })
}

// 查询教职工请假信息详细
export function getFacultyinfo(id) {
  return request({
    url: '/hk/facultyinfo/' + id,
    method: 'get'
  })
}

// 新增教职工请假信息
export function addFacultyinfo(data) {
  return request({
    url: '/hk/facultyinfo',
    method: 'post',
    data: data
  })
}

// 修改教职工请假信息
export function updateFacultyinfo(data) {
  return request({
    url: '/hk/facultyinfo',
    method: 'put',
    data: data
  })
}

// 删除教职工请假信息
export function delFacultyinfo(id) {
  return request({
    url: '/hk/facultyinfo/' + id,
    method: 'delete'
  })
}
