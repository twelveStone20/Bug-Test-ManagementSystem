import request from '@/utils/testc'

export const testUserRegisterService = ({ username, password, repassword }) => {
  return request.post('http://localhost:8080/register', { username, password, repassword })
}

export const testUserLoginService = ({ username, password }) => {
  return request.post('http://localhost:8080/login', { username, password })
}

export const testGetInfoService = () => {
  return request.get('http://localhost:8080/userList')
}

export const testGetUserInfoService = () => {
  return request.get('http://localhost:8080/userInfo')
}
