import Vue from 'vue'
import Router from 'vue-router'
import MainPage from '@/components/MainPage'
import Test from '@/components/Test'
import Login from '@/components/Login'
import Review from '@/components/Review'
import PwChange from '@/components/PwChange'
import DeliveryNoItem from '@/components/DeliveryNoItem'
import DeliveryItem from '@/components/DeliveryItem'
import DeliveryInfo from '@/components/DeliveryInfo'
import UserPage from '@/components/UserPage'
import JoinUser from '@/components/JoinUser'
import UserInfoChange from '@/components/UserInfoChange'
import UserInfoLocker from '@/components/UserInfoLocker'
import QnA from '@/components/QnA'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'MainPage',
      component: MainPage
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/review',
      name: 'Review',
      component: Review
    },
    {
      path: '/pwchange',
      name: 'PwChange',
      component: PwChange
    },
    {
      path: '/deliverynoitem',
      name: 'DeliveryNoItem',
      component: DeliveryNoItem
    },
    {
      path: '/deliveryitem',
      name: 'DeliveryItem',
      component: DeliveryItem
    },
    {
      path: '/deliveryinfo',
      name: 'DeliveryInfo',
      component: DeliveryInfo
    },
    {
      path: '/userpage',
      name: 'UserPage',
      component: UserPage
    },
    {
      path: '/joinuser',
      name: 'JoinUser',
      component: JoinUser
    },
    {
      path: '/userinfochange',
      name: 'userinfochange',
      component: UserInfoChange
    },
    {
      path: '/userinfolocker',
      name: 'userinfolocker',
      component: UserInfoLocker
    },
    {
      path: '/qna',
      name: 'is qna',
      component: QnA
    },
  ]
})
