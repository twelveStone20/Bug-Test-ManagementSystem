import { getTeamInfoService } from '@/api/team'
import { defineStore } from 'pinia'
import { ref } from 'vue'
//import { userGetInfoService } from '@/api/user'
//import { testGetUserInfoService } from '@/api/testc'
export const useTeamStore = defineStore(
  'team',
  () => {
    const team = ref({})
    const getTeam = async (creatorId) => {
      const res = await getTeamInfoService(creatorId)
      team.value = res.data.data
    }
    const setTeam = (obj) => {
      team.value = obj
    }
    return {
      team,
      getTeam,
      setTeam
    }
  },
  {
    persist: true
  }
)
