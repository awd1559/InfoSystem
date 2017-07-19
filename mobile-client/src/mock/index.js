import Mock from 'mockjs'
import loginAPI from './login'
import StudyAPI from './study'

// 登录相关
Mock.mock(/\/login\/loginbyemail/, 'post', loginAPI.loginByEmail)
Mock.mock(/\/login\/logout/, 'post', loginAPI.logout)
// Mock.mock(/\/user\/info\.*/, 'get', loginAPI.getInfo)

Mock.mock(/\/studycategory\/all/, 'get', StudyAPI.studycategory.all)

Mock.mock(/\/study\/list/, 'get', StudyAPI.study.allByCateId)

export default Mock
