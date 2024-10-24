import { defineStore } from 'pinia'
import { ref } from 'vue'
//import { userGetInfoService } from '@/api/user'
//import { testGetUserInfoService } from '@/api/testc'
export const useProjectStore = defineStore(
  'project',
  () => {
    const project = ref({})
    const getProject = async () => {
      //const res = await testGetUserInfoService()
    }
    const setProject = (obj) => {
      project.value = obj
    }
    return {
      project,
      getProject,
      setProject
    }
  },
  {
    persist: true
  }
)
