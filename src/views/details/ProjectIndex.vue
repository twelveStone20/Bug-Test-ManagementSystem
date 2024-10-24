<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { ArrowRight } from '@element-plus/icons-vue'
import { Picture as IconPicture } from '@element-plus/icons-vue'
import { useUserStore } from '@/stores'
const selectedValue = ref('')
const router = useRouter()
const userStore = useUserStore()
userStore.getUser()
const goTOProjectModules = () => {
  router.push('/project/oneproject/modules')
}
</script>
<template>
  <el-card class="projectOneIndexPage">
    <div class="header">
      <el-breadcrumb :separator-icon="ArrowRight">
        <el-breadcrumb-item :to="{ path: '/project/overview' }">项目全览</el-breadcrumb-item>
        <el-breadcrumb-item><strong>敏捷研发项目</strong></el-breadcrumb-item>
      </el-breadcrumb>
      <div class="extra">
        <el-button type="primary" @click="goTOProjectModules">查看项目模块</el-button>
        <el-button type="primary">编辑项目信息</el-button>
      </div>
    </div>
    <div class="container">
      <div class="projectOneIndexContent">
        <div class="projectOneIndexForm">
          <el-form :inline="true" label-width="auto">
            <el-form-item label="项目负责人：">
              <el-input
                v-model="userStore.user.username"
                style="width: 200px"
                show-word-limit
                type="text"
                disabled
              />
            </el-form-item>
            <el-form-item label="项目状态：" style="width: 55%">
              <el-select v-model="selectedValue" style="width: 50%">
                <el-option label="未开始" value="option1" />
                <el-option label="进行中" value="option2" />
                <el-option label="已完成" value="option3" />
              </el-select>
            </el-form-item>
            <el-form-item label="项目计划周期：">
              <div class="block">
                <el-date-picker
                  v-model="value2"
                  type="datetimerange"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期"
                  format="YYYY-MM-DD HH:mm:ss"
                  date-format="YYYY/MM/DD ddd"
                  time-format="A hh:mm:ss"
                />
              </div>
            </el-form-item>
            <el-form-item label="Bug每日新增趋势：" style="display: block">
              <div class="trend">
                <span class="demonstration">Custom</span>
                <el-image>
                  <template #error>
                    <div class="image-slot">
                      <el-icon><icon-picture /></el-icon>
                    </div>
                  </template>
                </el-image>
              </div>
            </el-form-item>
          </el-form>
        </div>
      </div>
      <div class="BugCard">
        <div class="Bug1">
          <el-statistic :value="0">
            <template #title>
              <div style="display: inline-flex; align-items: center; font-size: 16px">
                进行中的Bug
                <el-tooltip
                  effect="dark"
                  content="Number of users who logged into the product in one day"
                  placement="top"
                >
                  <el-icon style="margin-left: 4px" :size="12">
                    <Warning />
                  </el-icon>
                </el-tooltip>
              </div>
            </template>
          </el-statistic>
        </div>
        <div class="Bug2">
          <el-statistic :value="0">
            <template #title>
              <div style="display: inline-flex; align-items: center; font-size: 16px">
                待处理的Bug
                <el-tooltip
                  effect="dark"
                  content="Number of users who logged into the product in one day"
                  placement="top"
                >
                  <el-icon style="margin-left: 4px" :size="12">
                    <Warning />
                  </el-icon>
                </el-tooltip>
              </div>
            </template>
          </el-statistic>
        </div>
      </div>
    </div>
  </el-card>
</template>
<style>
.projectOneIndexPage {
  min-height: 100%;
  box-sizing: border-box;
  .header {
    display: flex;
    padding: 5px;
    justify-content: space-between;
    align-items: center;
  }
}
.container {
  display: flex;
}
.projectOneIndexContent {
  margin-top: 2%;
  margin-left: 10px;
  max-width: 78%;
}
.BugCard {
  margin-top: 2%;
  height: 100%;
  max-width: 22%;
  .el-statistic {
    height: 100px;
  }
  .Bug1 {
    height: 50%;
  }
  .Bug2 {
    height: 50%;
  }
}
</style>
