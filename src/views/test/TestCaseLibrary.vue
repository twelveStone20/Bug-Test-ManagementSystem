<script setup>
import { getAllUsecaseLibService, addUsecaseLibService } from '@/api/usecaselib'
import { useUserStore } from '@/stores'
import { useTeamStore } from '@/stores/modules/team'
import { useUsecaseLibStore } from '@/stores/modules/usercaselib'
import { Edit } from '@element-plus/icons-vue'
import { ref } from 'vue'
//import { TabsPaneContext } from 'element-plus'
import { useRouter } from 'vue-router'
const activeName = ref('all')
const router = useRouter()

const userStore = useUserStore()
userStore.getUser()

const teamStore = useTeamStore()
teamStore.getTeam(userStore.user.userId)

//获取用例库信息
const tableData = ref([])
const getUsecaseLibList = async (teamId) => {
  const res = await getAllUsecaseLibService(teamId)
  tableData.value = res.data.data
}
getUsecaseLibList(teamStore.team.teamId)
//查看用例库
const goToOneUsecaseLib = async (usecaseLibId) => {
  const usecaseLibStore = useUsecaseLibStore()
  usecaseLibStore.setUsecaseLibId(usecaseLibId)
  router.push('/test/testonecaselibrary')
  console.log(usecaseLibId)
}
const handleClick = (tab, event) => {
  console.log(tab, event)
}

//新建用例库
const addUsecaseLibFormVisible = ref(false)
const addUsecaseLibFormRef = ref()
const addUsecaseLibFormModel = ref({
  usecaseLibraryName: '',
  libRelateTeamId: teamStore.team.teamId,
  libCreatorId: userStore.user.userId,
  libCreatorName: userStore.user.username
})
const addUsecaseLib = async () => {
  await addUsecaseLibFormRef.value.validate()
  await addUsecaseLibService(addUsecaseLibFormModel.value)
  ElMessage.success('创建成功')
  addUsecaseLibFormVisible.value = false
}
</script>
<template>
  <div class="card-container">
    <el-card class="projectPage">
      <div class="header">
        <el-breadcrumb :separator-icon="ArrowRight">
          <el-breadcrumb-item><strong>用例库</strong></el-breadcrumb-item>
        </el-breadcrumb>
        <div class="extra">
          <el-button type="primary" @click="addUsecaseLibFormVisible = true">新增用例库</el-button>
        </div>
      </div>
      <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
        <el-tab-pane label="全部用例库" name="all">
          <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column type="index" label="序号" width="100" />
            <el-table-column v-if="false" prop="usecaseLibraryId" label="用例库ID" width="100" />
            <el-table-column prop="usecaseLibraryName" label="用例库名称" width="150" />
            <el-table-column prop="usecaseNumber" label="测试用例数量" width="150" />
            <el-table-column prop="libCreatorName" label="创建者"></el-table-column>
            <el-table-column label="查看" width="150">
              <template #default="scope">
                <el-button
                  type="primary"
                  :icon="Edit"
                  circle
                  @click="goToOneUsecaseLib(scope.row.usecaseLibraryId)"
                />
              </template>
            </el-table-column>
          </el-table>
          <template #empty>
            <el-empty description="没有数据"></el-empty>
          </template>
        </el-tab-pane>
      </el-tabs>
      <div class="footer">
        <span
          ><strong>所属团队：{{ teamStore.team.teamName }}</strong></span
        >
      </div>
      <el-dialog v-model="addUsecaseLibFormVisible" title="新建用例库" width="560">
        <el-form :model="addUsecaseLibFormModel" ref="addUsecaseLibFormRef">
          <el-form-item label="用例库名称" style="display: block" prop="usecaseLibraryName">
            <el-input
              v-model="addUsecaseLibFormModel.usecaseLibraryName"
              style="width: 100%"
              placeholder="请填入用例库名称，此处不能为空"
              show-word-limit
              type="text"
            />
          </el-form-item>
          <el-form-item label="用例库创建者" style="display: block">
            <el-input v-model="userStore.user.username" style="width: 100%" type="text" disabled />
          </el-form-item>
          <el-form-item label="所属团队" style="display: block">
            <el-input v-model="teamStore.team.teamName" style="width: 100%" type="text" disabled />
          </el-form-item>
        </el-form>
        <template #footer>
          <div class="dialog-footer">
            <div>
              <el-button @click="addUsecaseLibFormVisible = false"> 取消 </el-button>
              <el-button type="primary" @click="addUsecaseLib"> 创建 </el-button>
            </div>
          </div>
        </template>
      </el-dialog>
    </el-card>
  </div>
</template>

<style scoped>
.projectPage {
  min-height: 100%;
  box-sizing: border-box;
}
.card-container {
  height: 100%;
  position: relative;
  .header {
    display: flex;
    padding: 5px;
    justify-content: space-between;
    align-items: center;
  }
  .footer {
    position: absolute;
    bottom: 10px;
    text-align: left;
  }
}

.demo-tabs {
  padding: 0 10px;
  margin-top: 10px;
}
.demo-tabs > .el-tabs__content {
  padding: 0px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
</style>
