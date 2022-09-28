import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listTest(query) {
  return request({
    url: '/system/test/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getTest(id) {
  return request({
    url: '/system/test/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addTest(data) {
  return request({
    url: '/system/test',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateTest(data) {
  return request({
    url: '/system/test',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delTest(id) {
  return request({
    url: '/system/test/' + id,
    method: 'delete'
  })
}
