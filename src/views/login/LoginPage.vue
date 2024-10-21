<script setup>
import { testUserRegisterService, testUserLoginService } from '@/api/testc'
import { useUserStore } from '@/stores'
import { User, Lock, View } from '@element-plus/icons-vue'
import { ref, watch } from 'vue'
import { useRouter } from 'vue-router'

const isRegister = ref(false) //注册登录控制

const formRef = ref()
const formModel = ref({
  username: '',
  password: '',
  repassword: ''
}) //收集表单数据
const rules = {
  username: [
    { required: true, message: '请输入用户名', trigger: 'change' },
    { min: 4, max: 10, message: '用户名必须是4到10位的字符', trigger: 'change' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'change' },
    { pattern: /^\S{6,15}$/, message: '密码必须是6-15位的非空字符', trigger: 'change' }
  ],
  repassword: [
    { required: true, message: '请再次输入密码', trigger: 'change' },
    { pattern: /^\S{6,15}$/, message: '密码必须是6-15位的非空字符', trigger: 'change' },
    {
      validator: (rule, value, callback) => {
        if (value !== formModel.value.password) {
          callback(new Error('两次密码输入不一致'))
        } else {
          callback()
        }
      },
      trigger: 'change'
    }
  ]
} //校验规则
const userStore = useUserStore() //用户信息存储
const router = useRouter() //路由对象
//注册
const register = async () => {
  await formRef.value.validate()
  await testUserRegisterService(formModel.value) //注册接口服务
  ElMessage.success('注册成功')
  isRegister.value = false
}
//登录
const login = async () => {
  await formRef.value.validate()
  const res = await testUserLoginService(formModel.value) //登录接口服务
  if (res.data.code === 1) {
    userStore.setToken(res.data.data)
    ElMessage.success('登录成功')
    router.push('/user/workbench')
  }
}
//监听表单切换时，重置数据
watch(isRegister, () => {
  formModel.value = {
    username: '',
    password: '',
    repassword: ''
  }
})
</script>
<template>
  <el-row class="login-page">
    <el-col :span="8" class="bg">
      <div class="picture"></div>
    </el-col>
    <el-col :span="6" :offset="5" class="form">
      <el-form
        :model="formModel"
        :rules="rules"
        ref="formRef"
        size="large"
        autocomplete="off"
        v-if="isRegister"
        status-icon
      >
        <!-- 注册表单 -->
        <el-form-item>
          <h1>注册</h1>
        </el-form-item>
        <!-- prop配置对应校验规则 -->
        <el-form-item prop="username">
          <el-input
            v-model="formModel.username"
            :prefix-icon="User"
            placeholder="请输入用户名"
          ></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model="formModel.password"
            :prefix-icon="Lock"
            type="password"
            placeholder="请输入密码"
          ></el-input>
        </el-form-item>
        <el-form-item prop="repassword">
          <el-input
            v-model="formModel.repassword"
            :prefix-icon="View"
            type="password"
            placeholder="请再次输入密码"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="注册" @click="register" size="large" color="#7766ff">注册</el-button>
        </el-form-item>
        <el-form-item class="fle">
          <el-link type="info" :underline="false" @click="isRegister = false"> 回到登录</el-link>
        </el-form-item>
      </el-form>
      <!-- 登录表单 -->
      <el-form
        :model="formModel"
        :rules="rules"
        ref="formRef"
        size="large"
        autocomplete="off"
        v-else
      >
        <el-form-item>
          <h1>登录</h1>
        </el-form-item>
        <el-form-item prop="username">
          <el-input
            v-model="formModel.username"
            :prefix-icon="User"
            placeholder="请输入用户名"
          ></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model="formModel.password"
            :prefix-icon="Lock"
            type="password"
            placeholder="请输入密码"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-checkbox value="记住密码" name="type"> 记住密码 </el-checkbox>
          <el-link class="forgetPassword" type="primary" :underline="false">忘记密码？</el-link>
        </el-form-item>
        <el-form-item>
          <el-button type="登录" @click="login" size="large" color="#7766ff">登录</el-button>
        </el-form-item>
        <el-form-item>
          <el-link type="info" :underline="false" @click="isRegister = true"> 注册</el-link>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>
<style scoped>
.picture {
  width: 100%;
  height: 100%;
  background-image: url('../../assets/LoginPage/login/login.png');
  background-size: cover;
}

.el-form {
  margin-top: 30%;
  margin-bottom: 40%;
  border: 1px solid rgb(225, 228, 234);
  border-radius: 10px;
  box-shadow: 0 4px 24px 0 rgba(0, 0, 0, 0.1);
  padding: 10%;
}
.el-button {
  width: 100%;
  margin: auto;
}
.forgetPassword {
  margin-top: -14%;
  margin-left: 75%;
}
</style>
