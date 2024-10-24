<script setup>
import { reactive, ref } from 'vue'
import { useUserStore } from '@/stores'
import { userUpdateInfoService } from '@/api/user'
// do not use same name with ref
const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: ''
})
const userFormRef = ref()
const {
  user: { username, job },
  getUser
} = useUserStore()
const userForm = ref({
  username,
  job
})
const submitUserForm = async () => {
  await userFormRef.value.validate()
  await userUpdateInfoService(userForm.value)
  getUser()
  ElMessage.success('修改成功')
}
const tableData = [
  {
    date: 'Project1',
    name: '管理员',
    address: 'No. 189, Grove St, Los Angeles'
  },
  {
    date: 'Project2',
    name: '管理员',
    address: 'No. 189, Grove St, Los Angeles'
  },
  {
    date: 'Project3',
    name: '管理员',
    address: 'No. 189, Grove St, Los Angeles'
  },
  {
    date: 'Project4',
    name: '管理员',
    address: 'No. 189, Grove St, Los Angeles'
  }
]
</script>
<template>
  <page-container title="基本资料">
    <el-form :model="form" label-width="auto" style="max-width: 600px">
      <el-form-item label="用户名">
        <el-input
          v-model="userForm.username"
          style="width: 240px"
          maxlength="10"
          show-word-limit
          type="text"
          disabled
        />
      </el-form-item>
    </el-form>
    <el-table :data="tableData" stripe style="width: 100%" title="项目职位信息">
      <el-table-column prop="date" label="加入项目" width="180" />
      <el-table-column prop="date" label="所属团队" width="180" />
      <el-table-column prop="name" label="职位" width="180" />
      <el-table-column prop="address" label="项目描述" />
    </el-table>
    <div class="submit">
      <el-button type="primary" @click="submitUserForm">更改</el-button>
      <el-button>恢复</el-button>
    </div>
  </page-container>
</template>
<style>
.submit {
  margin-top: 5%;
}
</style>
