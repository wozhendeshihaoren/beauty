// index.ts
// 获取应用实例
const app = getApp<IAppOption>()

Page({
  data: {
     banners:[],
     flag:true,
     httpurl: 'http://localhost:82/',
     imageurl: 'http://localhost:82/static/',
     navs: [],
     projects: [],
     pageNum: 1
     
  },
  toNavDetails:function(e){
    wx.navigateTo({
      url:'/pages/toNavDetails/toNavDetails?id='+e.currentTarget.dataset.id
    })
  },
  /**
   * 跳转到详细页面
   * @param e 
   */
  toProDetails:function(e){
  
    // console.log(e.currentTarget.dataset.id)
    wx.navigateTo({
      url:'/pages/preDeatils/preDeatils?id='+e.currentTarget.dataset.id
    })
  },
  /**
   * 跳转到预约页面
   * @param e 
   */
  toOrder:function(e){
    console.log(e.currentTarget.dataset.proid)
    wx.getStorage({
      key:'user',
      success:function(){
        // console.log(e.currentTarget.dataset.proid)
        wx.navigateTo({
          url:'/pages/order/order?proid='+e.currentTarget.dataset.proid
        })
      },
      fail:function(){
        // 提示
        wx.showToast({
          title: '请先登录',
          icon: 'success',
          duration: 2000
        })
  
        // 跳转
        setTimeout(() => {
          wx.navigateTo({
            url: '/pages/login/login'
          })
        }, 2000);
      }
    })
  },



   lower:function() {
    var that = this;
    if(that.data.flag){
      that.data.pageNum++;
    wx.request({
      url: this.data.httpurl+"project/all",
      data:{
        pageNum: that.data.pageNum,
        size: 10
      },
      success:function(res){
        if(res.data.code == 0){
          var newProjects = [...res.data.data.allProject,...that.data.projects];
          var bool = true;
          if(newProjects.length == res.data.data.total){""
            bool = false;
          }
          that.setData({
            projects:newProjects,
            flag:bool
          })
        }
      }
    }) 
    }
   },
  // 事件处理函数
  bindViewTap() {
    wx.navigateTo({
      url: '../logs/logs',
    })
  },
  onLoad() {
    var that = this;
    // @ts-ignore
   wx.request({
     url: that.data.httpurl+"image/banner",
     success:function (res) {
        that.setData({
          banners: res.data,
        })
     } 
   }),
   wx.request({
     url: that.data.httpurl+"image/nav",
     success:function (res) {
       console.log(res.data)
      that.setData({
        navs: res.data,
      })       
   } 
   })
   wx.request({
    url:that.data.httpurl+"project/all",
    data: {
      pageNum: that.data.pageNum,
      size: 10
    },
    success:function(res){
      console.log(res.data);
      if(res.data.code == 0){
        that.setData({
          projects:res.data.data.allProject
        })
      }
     
    }
  }) 
  },
  getUserProfile() {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    })
  },
  getUserInfo(e: any) {
    // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
    console.log(e)
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
