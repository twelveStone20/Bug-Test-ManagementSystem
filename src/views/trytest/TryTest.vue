<script setup>
import { testGetInfoService } from '@/api/testc'

import { ref, onMounted } from 'vue'

const testData = ref([])
async function fetchUsers() {
  try {
    console.log('123')
    const response = await testGetInfoService()
    testData.value = response.data.data
  } catch (error) {
    console.error('There was an error fetching the users!', error)
  }
}
onMounted(() => {
  fetchUsers()
})
</script>

<template>
  <el-card>
    <el-table :data="testData" stripe style="width: 100%" title="用户信息">
      <el-table-column prop="id" label="用户id" width="180" />
      <el-table-column prop="username" label="用户名" width="200" />
      <el-table-column prop="password" label="密码" />
      <el-table-column label="操作/查看" width="200">
        <el-button type="primary">编辑</el-button>
        <el-button type="primary">删除</el-button>
      </el-table-column>
    </el-table>
  </el-card>
</template>
