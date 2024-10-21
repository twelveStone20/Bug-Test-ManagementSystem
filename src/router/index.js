import { createRouter, createWebHistory } from 'vue-router'
import { useUserStore } from '@/stores'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/login', component: () => import('@/views/login/LoginPage.vue') },
    {
      path: '/',
      component: () => import('@/views/layout/LayoutContainer.vue'),
      redirect: '/login',
      children: [
        {
          path: '/user/profile',
          component: () => import('@/views/user/UserProfile.vue')
        },
        {
          path: '/user/password',
          component: () => import('@/views/user/UserPassword.vue')
        },
        {
          path: '/user/workbench',
          component: () => import('@/views/user/UserWorkbench.vue')
        },
        {
          path: '/project/overview',
          component: () => import('@/views/project/ProjectOverview.vue')
        },
        {
          path: '/project/oneproject',
          component: () => import('@/views/details/ProjectIndex.vue')
        },
        {
          path: '/project/oneproject/modules',
          component: () => import('@/views/details/ProjectModulesIndex.vue')
        },
        {
          path: '/project/oneproject/modules/onemodule',
          component: () => import('@/views/details/ProjectOneModuleIndex.vue')
        },
        {
          path: '/test/testplan',
          component: () => import('@/views/test/TestPlan.vue')
        },
        {
          path: '/test/testoneplan',
          component: () => import('@/views/details/TestOnePlan.vue')
        },
        {
          path: '/test/testplanonemodule',
          component: () => import('@/views/details/TestPlanOneModule.vue')
        },
        {
          path: '/test/testrequire',
          component: () => import('@/views/test/TestRequire.vue')
        },
        {
          path: '/test/testonerequirement',
          component: () => import('@/views/details/TestOneRequirement.vue')
        },
        {
          path: '/test/testcaselibrary',
          component: () => import('@/views/test/TestCaseLibrary.vue')
        },
        {
          path: '/test/testonecaselibrary',
          component: () => import('@/views/details/TestOneCaseLibrary.vue')
        },
        {
          path: '/test/testcase',
          component: () => import('@/views/details/TestCase.vue')
        },
        {
          path: '/configurationcenter',
          component: () => import('@/views/configuration/ConfigurationCenter.vue')
        },
        {
          path: '/user/profile',
          component: () => import('@/views/user/UserProfile.vue')
        },
        {
          path: '/trytest',
          component: () => import('@/views/trytest/TryTest.vue')
        }
      ]
    }
  ]
})
router.beforeEach((to) => {
  const useStore = useUserStore()
  if (!useStore.token && to.path !== '/login') return '/login'
  return true
})
export default router
