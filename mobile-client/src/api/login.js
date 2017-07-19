import http from './http'

export function loginByEmail(email, password, callback) {
	const data = {
    	email,
    	password
  	}
	http.post('/login/loginbyemail', data, callback)
}
