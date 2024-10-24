import request from '@/utils/testc'

export const addProjectService = ({ projectName, managerId, managerName, priority }) => {
  return request.post('http://localhost:8080/addproject', {
    projectName,
    managerId,
    managerName,
    priority
  })
}

export const getAllProjectService = (managerId) => {
  return request.get('http://localhost:8080/allproject/' + managerId)
}

export const deleteProjectService = (projectId) => {
  return request.delete('http://localhost:8080/deleteproject/' + projectId)
}
