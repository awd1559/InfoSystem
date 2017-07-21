import Mock from 'mockjs'
import StudyAPI from './study'

// study
Mock.mock('http://localhost:8080/studycategory/all', 'get', StudyAPI.studycategory.all)
Mock.mock(/\/study\/list/, 'get', StudyAPI.study.allByCateId)
Mock.mock(/\/study\/one/, 'get', StudyAPI.study.getById)
Mock.mock(/\/study\/update/, 'post', StudyAPI.study.getById)

// note

export default Mock
