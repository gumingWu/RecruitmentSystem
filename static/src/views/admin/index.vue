<template>
  <div>
      <div class="topbar">
          <div style="float:left; padding:13px; margin-left:50px">
                <router-link :to="{name:'introhome'}">
                    <el-image
                    style="width: 40px; height: 40px"
                    :src="require('../../assets/logo.png')"
                    fit="fit">
                    </el-image>
                </router-link>
            </div>
      </div>
      <router-view></router-view>
    <!-- <img :src="login_center_bg" class="login-center-layout"> -->
    <img src="@/assets/images/loginback.jpg" class="login-center-layout">
  </div>
</template>

<script>
  import login_center_bg from '@/assets/images/loginback.jpg'

  export default {
    name: 'login',
    data() {
      const validatePass = (rule, value, callback) => {
        if (value.length < 3) {
          callback(new Error('密码不能小于3位'))
        } else {
          callback()
        }
      };
      return {
        loginForm: {
          username: '',
          password: '',
        },
        loginRules: {
          username: [{required: true, trigger: 'blur'}],
          password: [{required: true, trigger: 'blur', validator: validatePass}]
        },
        loading: false,
        pwdType: 'password',
        login_center_bg,
        supportDialogVisible:false
      }
    },
    created() {
      if(this.loginForm.username === undefined||this.loginForm.username==null||this.loginForm.username===''){
        this.loginForm.username = 'admin';
      }
      if(this.loginForm.password === undefined||this.loginForm.password==null){
        this.loginForm.password = '';
      }
    },
    methods: {
      showPwd() {
        if (this.pwdType === 'password') {
          this.pwdType = ''
        } else {
          this.pwdType = 'password'
        }
      },
      handleLogin() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            // let isSupport = getSupport();
            // if(isSupport===undefined||isSupport==null){
            //   this.dialogVisible =true;
            //   return;
            // }
            this.loading = true;
            this.$store.dispatch('Login', this.loginForm).then(() => {
              this.loading = false;
              this.$router.push({path: '/'})
            }).catch(() => {
              this.loading = false
            })
          } else {
            console.log('参数验证不合法！');
            return false
          }
        })
      },
      dialogConfirm(){
        this.dialogVisible =false;
      },
      dialogCancel(){
        this.dialogVisible = false;
      }
    }
  }
</script>

<style scoped>
.topbar{
    position: absolute;
    width:100%;
    height:60px;
    background-color:#191819;
    color:white;
}
  .login-form-layout {
    position: absolute;
    /* left: 0; */
    right: 90px;
    width: 360px;
    margin: 180px auto;
    border-top: 10px solid #409EFF;
  }

  .login-title {
    text-align: center;
  }

  .login-center-layout {
    background: #409EFF;
    width: auto;
    height: auto;
    max-width: 100%;
    max-height: 100%;
  }
</style>
