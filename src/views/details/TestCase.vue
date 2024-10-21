<script lang="ts" setup>
import { ArrowLeft } from '@element-plus/icons-vue'
//import { UploadInstance } from 'element-plus'
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const activeName = ref('CaseExecute')
const activeNames = ref(['condition'])
const resultStateButtonValue = ref(true)
const textarea = ref('')
const backToTestModule = () => {
  router.push(`/test/testplanonemodule`)
}
const handleClick = (tab, event) => {
  console.log(tab, event)
}
const handleChange = (val) => {
  console.log(val)
}
// const uploadRef = ref<UploadInstance>()

// const submitUpload = () => {
//   uploadRef.value!.submit()
// }
</script>
<template>
  <el-card>
    <template v-slot:header>
      <div class="testcase-container">
        <div class="left">
          <el-page-header :icon="ArrowLeft" @click="backToTestModule">
            <template #content>
              <span class="testcase-header"> 所在测试计划：敏捷研发项目-测试计划1 </span>
            </template>
          </el-page-header>
          <div class="testcase-content">
            <div class="casename" style="display: flex; justify-content: space-between">
              <span>测试用例1</span>
              <el-button type="primary">编辑用例信息</el-button>
            </div>
            <div class="caseinfo">
              <el-descriptions :column="2" size="smaller" class="mt-4">
                <el-descriptions-item label="优先级："> P0 </el-descriptions-item>
                <el-descriptions-item label="用例类型：">功能测试</el-descriptions-item>
                <el-descriptions-item label="维护人：">zihang001</el-descriptions-item>
                <el-descriptions-item label="创建时间：">2024-09-02</el-descriptions-item>
                <el-descriptions-item label="执行人：">zihang001</el-descriptions-item>
                <el-descriptions-item label="最近更新时间：">2024-09-29</el-descriptions-item>
                <el-descriptions-item label="所属项目：">敏捷研发项目</el-descriptions-item>
                <el-descriptions-item label="所属模块：">敏捷研发项目-主模块</el-descriptions-item>
                <el-descriptions-item label="所属用例库：">用例库1</el-descriptions-item>
              </el-descriptions>
              <div class="functionButton" style="display: flex; justify-content: flex-end">
                <el-button type="primary">提测试需求</el-button>
                <el-button type="primary">关联Bug</el-button>
              </div>
              <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
                <el-tab-pane label="用例执行" name="CaseExecute">
                  <el-collapse v-model="activeNames" @change="handleChange">
                    <el-collapse-item title="前置条件" name="condition">
                      <div>未填写</div>
                    </el-collapse-item>
                    <el-collapse-item title="按步骤执行" name="executeByStep"
                      ><el-table stripe style="width: 100%">
                        <el-table-column prop="testRequireID" label="测试需求ID" width="100" />
                        <el-table-column prop="testRequireName" label="测试需求名称" width="150" />
                        <el-table-column prop="testRequireMaintainer" label="维护人" width="100" />
                        <el-table-column prop="testRequireManager" label="负责人" width="100" />
                        <el-table-column prop="testRequirePriority" label="优先级" width="100" />
                        <el-table-column prop="testRequireDescription" label="测试描述" />
                        <el-table-column prop="testRequireState" label="状态" width="100" />
                        <el-table-column label="操作/查看" width="100">
                          <el-button type="primary" />
                        </el-table-column> </el-table
                    ></el-collapse-item>
                    <el-collapse-item title="备注" name="notes">未填写</el-collapse-item>
                  </el-collapse>
                </el-tab-pane>
              </el-tabs>
            </div>
          </div>
        </div>
        <div class="right">
          <div class="casename">
            <span>执行结果</span>
          </div>
          <el-switch
            v-model="resultStateButtonValue"
            active-text="通过"
            style="--el-switch-on-color: #13ce66"
            class="success"
          >
          </el-switch>
          <el-switch
            v-model="resultStateButtonValue"
            active-text="失败"
            style="--el-switch-on-color: #fd3801"
            class="fail"
          >
          </el-switch>
          <el-switch
            v-model="resultStateButtonValue"
            active-text="阻塞"
            style="--el-switch-on-color: #f69000"
            class="blocked"
          >
          </el-switch>
          <el-switch
            v-model="resultStateButtonValue"
            active-text="跳过"
            style="--el-switch-on-color: #007af8"
            class="skip"
          >
          </el-switch>
          <div class="lastExcuteTime">
            <span>最后执行时间</span>
            <div style="margin-top: 5px; font-size: smaller">2024-09-29</div>
          </div>
          <div class="resultNote" style="margin-top: 20px">
            <span>执行结果备注</span>
            <div style="margin-top: 10px">
              <el-input
                v-model="textarea"
                style="width: 95%"
                :rows="5"
                type="textarea"
                placeholder="添加执行结果备注"
              />
            </div>
          </div>
          <div class="uploadFiles" style="margin-top: 20px">
            <span>执行结果附件</span>
            <div style="margin-top: 5px">
              <el-upload
                ref="uploadRef"
                class="upload-demo"
                action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
                :auto-upload="false"
              >
                <el-button type="primary">选择文件</el-button>

                <el-button class="ml-3" type="success"> 上传至服务器 </el-button>

                <template #tip>
                  <div class="el-upload__tip">jpg/png files with a size less than 500kb</div>
                </template>
              </el-upload>
            </div>
          </div>
        </div>
      </div>
    </template>
  </el-card>
</template>
<style>
.testcase-container {
  display: flex;
  justify-content: space-between;
  height: 100%;
}
.left {
  width: 60%;
}
.testcase-header {
  font-size: small;
}
.testcase-content {
  border-top: 3px solid #fff8ff;
  margin-top: 10px;
  padding-top: 10px;
  .caseinfo {
    margin-top: 20px;
  }
}
.right {
  width: 35%;
  border-left: 1px solid rgb(204, 199, 199);
  padding-left: 2%;
}
.el-switch {
  margin-top: 5%;
  margin-right: 5%;
}
.success.is-checked .el-switch__label--right {
  color: #13ce66;
}
.fail.is-checked .el-switch__label--right {
  color: #fd3801;
}
.blocked.is-checked .el-switch__label--right {
  color: #f69000;
}
.skip.is-checked .el-switch__label--right {
  color: #007af8;
}
.lastExcuteTime {
  margin-top: 10px;
}
</style>
