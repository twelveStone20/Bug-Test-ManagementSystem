import axios from 'axios'
import { useUserStore } from '../stores'
import router from '../router'
const testBaseURL = 'http://localhost:8080'
const testInstance = axios.create({
  testBaseURL,
  timeout: 10000
})

testInstance.interceptors.request.use(
  (config) => {
    const useStore = useUserStore()
    if (useStore.token) {
      config.headers.Authorization = useStore.token //请求头
      console.log(config.headers.Authorization)
    }
    return config
  },
  (err) => Promise.reject(err)
)

// 响应拦截器
testInstance.interceptors.response.use(
  (res) => {
    if (res.data.code === 1) {
      return res
    }
    ElMessage.error(res.data.message || '用户名或密码错误')
    return Promise.reject(res.data)
  },
  (err) => {
    if (err.response?.status === 401) {
      router.push('/login')
    }
    ElMessage.error(err.response.data.message || '服务异常')
    return Promise.reject(err)
  }
)
export default testInstance
