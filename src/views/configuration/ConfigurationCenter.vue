<script lang="ts" setup>
import { ref } from 'vue'
import { TabsInstance } from 'element-plus'
import { DrawerProps } from 'element-plus'
import { useUserStore } from '@/stores'
import { useTeamStore } from '@/stores/modules/team'
const activeName = ref('teamConfig')

const userStore = useUserStore()
userStore.getUser()
const teamStore = useTeamStore()
teamStore.getTeam(userStore.user.userId)

const handleClick = (tab, event) => {
  console.log(tab, event)
}
const selectedValue = ref('')

const tabPosition = ref<TabsInstance['tabPosition']>('left')
const tableData = [
  {
    username: teamStore.team.teamManager.username
  }
]
const projectTableData = [
  {
    projectID: '01',
    projectName: '敏捷研发项目',
    projectManager: 'zihang001'
  }
]
const projectRoleTableData = [
  {
    roleName: '管理人员',
    projectUseIn: '所有项目'
  },
  {
    roleName: '测试人员',
    projectUseIn: '所有项目'
  },
  {
    roleName: '开发人员',
    projectUseIn: '所有项目'
  }
]

const drawer = ref(false)
const drawer2 = ref(false)
const direction = ref<DrawerProps['direction']>('rtl')
</script>
<template>
  <el-card class="configCard">
    <div class="header">
      <span><strong>配置中心</strong></span>
      <div class="extra">
        <el-button type="primary">保存配置</el-button>
      </div>
    </div>
    <el-tabs v-model="activeName" type="card" class="demo-tabs" @tab-click="handleClick">
      <el-tab-pane label="团队成员" name="teamMember">
        <div class="teamMem">
          <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="username" label="用户名" width="1000" />
            <el-table-column label="移出成员">
              <el-button type="primary" />
            </el-table-column>
          </el-table>
        </div>
        <template #empty>
          <el-empty description="没有数据"></el-empty>
        </template>
        <div class="joinTeam">
          <el-link type="primary">邀请用户加入团队</el-link>
        </div>
      </el-tab-pane>
      <el-tab-pane label="团队配置" name="teamConfig">
        <div class="teamConfiguration">
          <el-form label-width="auto">
            <el-form-item label="我的团队：">
              <el-input
                v-model="teamStore.team.teamName"
                style="width: 200px"
                show-word-limit
                type="text"
                disabled
              />
            </el-form-item>
            <el-form-item label="团队负责人：" style="width: 35%">
              <el-input
                v-model="teamStore.team.teamManager.username"
                style="width: 200px"
                show-word-limit
                type="text"
                disabled
              />
            </el-form-item>
          </el-form>
          <div class="teamPermission">
            <div class="permissionHeader">团队权限-操作权限对应成员</div>
            <div class="permissionContent">
              <el-collapse>
                <el-collapse-item title="邀请团队成员" name="1">
                  <div>
                    Consistent with real life: in line with the process and logic of real life, and
                    comply with languages and habits that the users are used to;
                  </div>
                  <div>
                    Consistent within interface: all elements should be consistent, such as: design
                    style, icons and texts, position of elements, etc.
                  </div>
                </el-collapse-item>
                <el-collapse-item title="管理用户组" name="2">
                  <div>
                    Operation feedback: enable the users to clearly perceive their operations by
                    style updates and interactive effects;
                  </div>
                  <div>
                    Visual feedback: reflect current state by updating or rearranging elements of
                    the page.
                  </div>
                </el-collapse-item>
                <el-collapse-item title="项目管理管理员" name="3">
                  <div>Simplify the process: keep operating process simple and intuitive;</div>
                  <div>
                    Definite and clear: enunciate your intentions clearly so that the users can
                    quickly understand and make decisions;
                  </div>
                  <div>
                    Easy to identify: the interface should be straightforward, which helps the users
                    to identify and frees them from memorizing and recalling.
                  </div>
                </el-collapse-item>
                <el-collapse-item title="测试管理管理员" name="4">
                  <div>
                    Decision making: giving advices about operations is acceptable, but do not make
                    decisions for the users;
                  </div>
                  <div>
                    Controlled consequences: users should be granted the freedom to operate,
                    including canceling, aborting or terminating current operation.
                  </div>
                </el-collapse-item>
                <el-collapse-item title="测试Bug确认人" name="5">
                  <div>
                    Decision making: giving advices about operations is acceptable, but do not make
                    decisions for the users;
                  </div>
                  <div>
                    Controlled consequences: users should be granted the freedom to operate,
                    including canceling, aborting or terminating current operation.
                  </div>
                </el-collapse-item>
              </el-collapse>
            </div>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane label="项目管理配置" name="projectConfig">
        <div class="projectConfiguration">
          <el-tabs :tab-position="tabPosition" style="height: 50vh" class="demo-tabs">
            <el-tab-pane label="项目管理">
              <el-table :data="projectTableData" stripe style="width: 100%">
                <el-table-column prop="projectID" label="项目ID" width="100" />
                <el-table-column prop="projectName" label="项目名称" width="180" />
                <el-table-column prop="projectState" label="项目状态" width="250">
                  <el-select v-model="selectedValue" width="150">
                    <el-option label="未开始" value="option1" />
                    <el-option label="进行中" value="option2" />
                    <el-option label="已完成" value="option3" />
                  </el-select>
                </el-table-column>
                <el-table-column prop="projectManager" label="项目负责人" />
                <el-table-column label="配置权限" width="150">
                  <el-button type="primary" @click="drawer2 = true"> </el-button>
                </el-table-column>
              </el-table>
              <el-drawer
                v-model="drawer2"
                title="I am the title"
                :direction="direction"
                size="1200"
              >
                <span>Hi, there!</span>
              </el-drawer>
            </el-tab-pane>
            <el-tab-pane label="项目角色">
              <el-table :data="projectRoleTableData" stripe style="width: 100%">
                <el-table-column prop="roleName" label="角色名称" />
                <el-table-column prop="projectUseIn" label="所使用到的项目" />
              </el-table>
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-tab-pane>
      <el-tab-pane label="测试管理配置" name="testConfig">
        <div class="testConfiguration">
          <el-tabs :tab-position="tabPosition" style="height: 50vh" class="demo-tabs">
            <el-tab-pane label="关联项目配置">
              <el-table :data="projectTableData" stripe style="width: 100%">
                <el-table-column prop="projectID" label="项目ID" width="100" />
                <el-table-column prop="projectName" label="项目名称" width="180" />
                <el-table-column prop="projectState" label="项目状态" width="250">
                  <el-select v-model="selectedValue" width="150">
                    <el-option label="未开始" value="option1" />
                    <el-option label="进行中" value="option2" />
                    <el-option label="已完成" value="option3" />
                  </el-select>
                </el-table-column>
                <el-table-column prop="projectManager" label="项目负责人" />
                <el-table-column label="配置测试权限" width="150">
                  <el-button type="primary" @click="drawer = true"> </el-button>
                </el-table-column>
              </el-table>
              <el-drawer v-model="drawer" title="I am the title" :direction="direction" size="1200">
                <span>Hi, there!</span>
              </el-drawer>
            </el-tab-pane>
            <el-tab-pane label="权限配置">
              <div class="testPermission">
                <div class="testPermissionHeader">测试权限-操作权限对应成员</div>
                <div class="testPermissionContent">
                  <el-collapse>
                    <el-collapse-item title="管理用例库" name="1">
                      <div>
                        Consistent with real life: in line with the process and logic of real life,
                        and comply with languages and habits that the users are used to;
                      </div>
                      <div>
                        Consistent within interface: all elements should be consistent, such as:
                        design style, icons and texts, position of elements, etc.
                      </div>
                    </el-collapse-item>
                    <el-collapse-item title="删除用例库" name="2">
                      <div>
                        Operation feedback: enable the users to clearly perceive their operations by
                        style updates and interactive effects;
                      </div>
                      <div>
                        Visual feedback: reflect current state by updating or rearranging elements
                        of the page.
                      </div>
                    </el-collapse-item>
                    <el-collapse-item title="管理测试计划" name="3">
                      <div>Simplify the process: keep operating process simple and intuitive;</div>
                      <div>
                        Definite and clear: enunciate your intentions clearly so that the users can
                        quickly understand and make decisions;
                      </div>
                      <div>
                        Easy to identify: the interface should be straightforward, which helps the
                        users to identify and frees them from memorizing and recalling.
                      </div>
                    </el-collapse-item>
                    <el-collapse-item title="管理测试需求" name="4">
                      <div>
                        Decision making: giving advices about operations is acceptable, but do not
                        make decisions for the users;
                      </div>
                      <div>
                        Controlled consequences: users should be granted the freedom to operate,
                        including canceling, aborting or terminating current operation.
                      </div>
                    </el-collapse-item>
                    <el-collapse-item title="管理测试用例" name="5">
                      <div>
                        Decision making: giving advices about operations is acceptable, but do not
                        make decisions for the users;
                      </div>
                      <div>
                        Controlled consequences: users should be granted the freedom to operate,
                        including canceling, aborting or terminating current operation.
                      </div>
                    </el-collapse-item>
                  </el-collapse>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="测试报告模板">测试报告</el-tab-pane>
            <el-tab-pane label="Task">Task</el-tab-pane>
          </el-tabs>
        </div>
      </el-tab-pane>
      <el-tab-pane label="用户组" name="userGroup">
        <div class="userG">
          <div>暂无用户组</div>
        </div>
        <div class="userGButton">
          <el-button type="primary">新建用户组</el-button>
        </div>
      </el-tab-pane>
    </el-tabs>
  </el-card>
</template>

<style scoped>
.configCard {
  min-height: 100%;
  box-sizing: border-box;
  .header {
    display: flex;
    padding: 5px;
    margin-bottom: 10px;
    justify-content: space-between;
    align-items: center;
  }
  .teamMem {
    padding-left: 15px;
  }
  .joinTeam {
    margin-top: 30%;
  }
  .teamConfiguration {
    padding-left: 15px;
  }
  .teamPermission {
    margin-top: 50px;
    font-size: 15px;
    .permissionContent {
      margin-top: 15px;
    }
  }
  .projectConfiguration {
    padding-left: 0px;
  }
  .testConfiguration {
    padding-left: 0px;
  }
  .testPermission {
    font-size: 15px;
    .testPermissionContent {
      margin-top: 15px;
    }
  }
  .userG {
    font-size: 15px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 10%;
  }
  .userGButton {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 2%;
  }
}
.demo-tabs > .el-tabs__content {
  padding-top: 5px;
  padding-left: 10px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
</style>
