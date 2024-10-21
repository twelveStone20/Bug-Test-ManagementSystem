import request from '@/utils/request'

export const userRegisterService = ({ username, password, repassword }) => {
  return request.post('/api/reg', { username, password, repassword })
}

export const userLoginService = ({ username, password }) => {
  return request.post('/api/login', { username, password })
}

export const userGetInfoService = () => {
  return request.get('/my/userinfo')
}

export const userUpdateInfoService = ({ job }) => {
  return request.put('/my/userinfo', job)
}

export const userUpdatePasswordService = ({ old_pwd, new_pwd, re_pwd }) => {
  return request.patch('my/updatepwd', { old_pwd, new_pwd, re_pwd })
}
