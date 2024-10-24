<script setup>
import {
  Suitcase,
  Folder,
  Notebook,
  Tickets,
  Setting,
  User,
  Crop,
  EditPen,
  SwitchButton
} from '@element-plus/icons-vue'
import { useUserStore } from '@/stores'
import { useRouter } from 'vue-router'
import avatar from '@/assets/avatar/pixelman.jpg'
const userStore = useUserStore()
userStore.getUser()
const handleOpen = (key, keyPath) => {
  console.log(key, keyPath)
}
const handleClose = (key, keyPath) => {
  console.log(key, keyPath)
}
const router = useRouter()
const goToProfile = () => {
  router.push(`/user/profile`)
}
const handleCommand = async (key) => {
  if (key === 'logout') {
    await ElMessageBox.confirm('你确认要退出登录吗？', '提示', {
      type: 'warning',
      confirmButtonText: '确认',
      cancelButtonText: '取消'
    })
    userStore.removeToken()
    userStore.setUser({})
    router.push(`login`)
  } else {
    router.push(`/user/${key}`)
  }
}
</script>

<template>
  <el-container class="layout-container" style="height: 100vh">
    <el-aside width="200px" height="100%">
      <el-menu
        active-text-color="#0066ff"
        active-background-color="#99ccff"
        class="el-menu-vertical-demo"
        :default-active="$route.path"
        router
        @open="handleOpen"
        @close="handleClose"
      >
        <el-menu-item class="icon" index="/user/workbench">
          <div class="iconContainer">
            <img src="../../assets/icon.png" />
            <span>Bug管理系统</span>
          </div>
        </el-menu-item>
        <el-menu-item index="/user/workbench">
          <el-icon><Suitcase /></el-icon>
          <span>我的工作台</span>
        </el-menu-item>
        <el-sub-menu index="1">
          <template #title>
            <el-icon><Folder /></el-icon>
            <span>项目管理</span>
          </template>
          <el-menu-item-group title="项目">
            <el-menu-item index="/project/overview"> 项目全览 </el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>
        <el-sub-menu index="2">
          <template #title>
            <el-icon><Notebook /></el-icon>
            <span>测试管理</span>
          </template>
          <el-menu-item-group title="测试">
            <el-menu-item index="/test/testplan">测试计划全览</el-menu-item>
            <el-menu-item index="/test/testrequire">测试需求</el-menu-item>
            <el-menu-item index="/test/testcaselibrary">用例库</el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>
        <el-menu-item index="/bug/buginfo">
          <el-icon><Tickets /></el-icon>
          <span>Bug管理</span>
        </el-menu-item>
        <el-menu-item index="/configurationcenter">
          <el-icon><Setting /></el-icon>
          <span>配置中心</span>
        </el-menu-item>
        <el-menu-item index="/user/profile">
          <el-icon><User /></el-icon>
          <span>用户中心</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header>
        <div class="user">
          <span
            >用户：<strong>{{ userStore.user.username }}</strong></span
          >
          <el-dropdown class="dropdown" placement="bottom-end" @command="handleCommand">
            <span class="el-dropdown__box">
              <el-avatar @click="goToProfile" :src="avatar" />
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item command="profile" :icon="User"> 基本资料 </el-dropdown-item>
                <el-dropdown-item command="avatar" :icon="Crop"> 更换头像 </el-dropdown-item>
                <el-dropdown-item command="password" :icon="EditPen"> 重置密码 </el-dropdown-item>
                <el-dropdown-item command="logout" :icon="SwitchButton">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<style>
.iconContainer {
  display: flex;
  align-items: center;
  justify-items: center;
  margin-top: 5px;
  margin-bottom: 20px;
}
.iconContainer span {
  display: flex;
  align-items: center;
  margin-left: 10px;
  margin-top: 10px;
  text-align: center;
  color: #0066ff;
  font-style: italic;
}
img {
  margin-left: 0px;
  margin-top: 10px;
  max-width: 25px;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
}
.el-menu-item.is-active {
  border-left: 4px solid #0066ff;
  background-color: #f0f8ff;
}
.icon.is-active {
  border-left: 0px;
  background-color: #ffffff;
}
.user {
  line-height: 60px;
  text-align: center;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
}
.el-dropdown :hover,
:focus {
  border: none;
  outline: none;
}
.el-main {
  background-color: #f2f2f2;
}
.main {
  height: 92%;
  padding: 20px;
  background-color: #ffffff;
}
.footer {
  text-align: center;
}
</style>
