import Mock from 'mockjs'
import StudyAPI from './study'

// study
Mock.mock(/\/studycategory\/all/, 'get', StudyAPI.studycategory.all)
Mock.mock(/\/study\/list/, 'get', StudyAPI.study.allByCateId)
Mock.mock(/\/study\/one/, 'get', StudyAPI.study.getById)

// coding

export default Mock
