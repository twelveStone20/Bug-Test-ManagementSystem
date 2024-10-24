import { getOneUsecaseLibService } from '@/api/usecaselib'
import { defineStore } from 'pinia'
import { ref } from 'vue'
//import { userGetInfoService } from '@/api/user'
//import { testGetUserInfoService } from '@/api/testc'
export const useUsecaseLibStore = defineStore(
  'usercaselib',
  () => {
    const usecaseLibId = ref(0)
    const setUsecaseLibId = (newLibId) => {
      usecaseLibId.value = newLibId
    }
    const removeToken = () => {
      usecaseLibId.value = 0
    }
    const usecaseLib = ref({})
    const getUsecaseLib = async () => {
      const res = await getOneUsecaseLibService(usecaseLibId.value)
      usecaseLib.value = res.data.data
    }
    const setUsecaseLib = (obj) => {
      usecaseLib.value = obj
    }
    return {
      usecaseLibId,
      setUsecaseLibId,
      removeToken,
      usecaseLib,
      getUsecaseLib,
      setUsecaseLib
    }
  },
  {
    persist: true
  }
)
