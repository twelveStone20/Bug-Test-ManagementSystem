<script setup>
import { ref } from 'vue'
import { useUserStore } from '@/stores'
import { userUpdatePasswordService } from '@/api/user'
import { useRouter } from 'vue-router'
const userStore = useUserStore()
const router = useRouter()
const {
  user: { username }
} = useUserStore()
const userForm = ref({
  username
})
const changePasswordFormRef = ref()
const changePasswordFormModel = ref({
  old_pwd: '',
  new_pwd: '',
  re_pwd: ''
})
//const checkOldPwd = (rule, value, callback) => {
//  if (value !== userForm.value.password) {
//    callback(new Error('输入错误'))
//  } else {
//    callback()
//  }
//}
const checkDifferent = (rule, value, callback) => {
  if (value === changePasswordFormModel.value.old_pwd) {
    callback(new Error('新密码不能与旧密码一样'))
  } else {
    callback()
  }
}
const checkSameAsNewPwd = (rule, value, callback) => {
  if (value !== changePasswordFormModel.value.new_pwd) {
    callback(new Error('确认密码必须和新密码一样'))
  } else {
    callback()
  }
}
const changePasswordRules = {
  old_pwd: [
    { required: true, message: '请输入原密码', trigger: 'change' },
    { pattern: /^\S{6,15}$/, message: '输入必须是6-15位的非空字符', trigger: 'change' }
  ],
  new_pwd: [
    { required: true, message: '请输入新密码', trigger: 'change' },
    { pattern: /^\S{6,15}$/, message: '新密码必须是6-15位的非空字符', trigger: 'change' },
    {
      validator: checkDifferent,
      trigger: 'change'
    }
  ],
  re_pwd: [
    { required: true, message: '请再次输入新密码', trigger: 'change' },
    { pattern: /^\S{6,15}$/, message: '新密码必须是6-15位的非空字符', trigger: 'change' },
    {
      validator: checkSameAsNewPwd,
      trigger: 'change'
    }
  ]
}
const submitChange = async () => {
  await ElMessageBox.confirm('你确认要修改密码吗？', '提示', {
    type: 'warning',
    confirmButtonText: '确认',
    cancelButtonText: '取消'
  })
  await changePasswordFormRef.value.validate()
  await userUpdatePasswordService(changePasswordFormModel.value)
  ElMessage.success('修改密码成功')
  userStore.setToken('')
  userStore.setUser({})
  router.push('/login')
  ElMessage.success('请重新登录')
}
const resetForm = () => {
  changePasswordFormRef.value.resetFields()
}
</script>
<template>
  <page-container title="修改密码">
    <el-form
      ref="changePasswordFormRef"
      :model="changePasswordFormModel"
      :rules="changePasswordRules"
      label-width="auto"
      size="large"
      autocomplete="off"
      status-icon
    >
      <el-form-item label="用户名：">
        <el-input v-model="userForm.username" prefix-icon="User" disabled> </el-input>
      </el-form-item>
      <el-form-item label="原密码：" prop="old_pwd">
        <el-input
          v-model="changePasswordFormModel.old_pwd"
          prefix-icon="Lock"
          type="password"
          placeholder="请输入原密码"
        >
        </el-input>
      </el-form-item>
      <el-form-item label="新密码：" prop="new_pwd">
        <el-input
          v-model="changePasswordFormModel.new_pwd"
          prefix-icon="Lock"
          type="password"
          placeholder="请输入新密码"
        ></el-input>
      </el-form-item>
      <el-form-item label="确认新密码：" prop="re_pwd">
        <el-input
          v-model="changePasswordFormModel.re_pwd"
          prefix-icon="View"
          type="password"
          placeholder="请再次输入新密码"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <div class="button">
          <el-button type="修改" color="#0066ff" @click="submitChange">修改</el-button>
          <el-button type="修改" color="#ffffff" style="border: 1px" @click="resetForm"
            >重置</el-button
          >
        </div>
      </el-form-item>
    </el-form>
  </page-container>
</template>
<style>
h1 {
  font-size: larger;
}
.el-form {
  max-width: 800px;
}
.button {
  margin-left: 25%;
}
</style>
