import request from '@/utils/request'

export function register(data){
    return request({
        url:'/admin/register',
        method:'post',
        data: data
    })
}