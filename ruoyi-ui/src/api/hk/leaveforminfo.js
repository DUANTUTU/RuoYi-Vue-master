import request from '@/utils/request'

// 查询学生请假列表
export function listLeaveforminfo(query) {
  return request({
    url: '/hk/leaveforminfo/list',
    method: 'get',
    params: query
  })
}

// 查询学生请假详细
export function getLeaveforminfo(id) {
  return request({
    url: '/hk/leaveforminfo/' + id,
    method: 'get'
  })
}

// 新增学生请假
export function addLeaveforminfo(data) {
  return request({
    url: '/hk/leaveforminfo',
    method: 'post',
    data: data
  })
}

// 修改学生请假
export function updateLeaveforminfo(data) {
  return request({
    url: '/hk/leaveforminfo',
    method: 'put',
    data: data
  })
}

// 删除学生请假
export function delLeaveforminfo(id) {
  return request({
    url: '/hk/leaveforminfo/' + id,
    method: 'delete'
  })
}

export function getUsername(id) {
  return request({
    url: '/hk/leaveforminfo/' + id,
    method: 'get'
  })
}
