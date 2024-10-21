import { defineStore } from 'pinia'
import { ref } from 'vue'
import { parseJwt } from '@/utils/jwtParse'
//import { userGetInfoService } from '@/api/user'
//import { testGetUserInfoService } from '@/api/testc'
export const useUserStore = defineStore(
  'user',
  () => {
    const token = ref('')
    const setToken = (newToken) => {
      token.value = newToken
    }
    const removeToken = () => {
      token.value = ''
    }
    const user = ref({})
    const getUser = async () => {
      //const res = await testGetUserInfoService()
      const res = parseJwt(token.value)
      user.value = res.payload
      console.log(user)
    }
    const setUser = (obj) => {
      user.value = obj
    }
    return {
      token,
      setToken,
      removeToken,
      user,
      getUser,
      setUser
    }
  },
  {
    persist: true
  }
)
