// pages/personal/personal.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
         userInfo:{},
         flag:true,
         orderType:["全部订单","待消费","已消费","预定中"], 
         currentActive: 0,
         httpurl:'http://localhost:82/',
         imageurl: 'http://localhost:82/static/',
         orders:[],
         totalFlag: 0,
         totalFollowFlag: 0,

  },


   /**
   * 点击跳转到退出页面
   */
  toExit:function(){
    wx.navigateTo({
      url:"/pages/exit/exit"
    })
  },
/**
 * 跳转到follow页面
 */
  toFollow:function(e){
    wx.navigateTo({
      url:'/pages/follow/follow?id='+ e.currentTarget.dataset.id
    })
  },

/**
 * 获取订单标题index
 */

orderTypeTap:function(e){
     var index = e.target.dataset.index;
     var state;
     switch(index){
      case 0:
        state = '';
        break;
      case 1:
        state = 1;
        break;
      case 2:
        state = 2;
        break;
      case 3:
        state = 0;
        break;
     }
    this.setData({
      currentActive:e.target.dataset.index
    })
     var that = this;
     wx.getStorage({
       key:"user",
       success:(res)=>{
        wx.request({
          url:that.data.httpurl +'order/getAll',
          data: {
            token: res.data.token,
            state: state
          },
          success:(result)=>{
            if(result.data.code == 0){
              that.setData({
                orders: result.data.data
              })
            }
          }
       })
       }
     })
   
},
/**
 * current改变时触发该事件
 *
 */
currentChange:function(e){
  var index = e.detail.current;
  var state;
  switch(index){
   case 0:
     state = '';
     break;
   case 1:
     state = 1;
     break;
   case 2:
     state = 2;
     break;
   case 3:
     state = 0;
     break;
  }
  this.setData({
    currentActive:e.detail.current
  })

  var that = this;
     wx.getStorage({
       key:"user",
       success:(res)=>{
        wx.request({
          url:that.data.httpurl +'order/getAll',
          data: {
            token: res.data.token,
            state: state
          },
          success:(result)=>{
            if(result.data.code == 0){
              that.setData({
                orders: result.data.data
              })
            }
          }
       })
       }
     })
},
/**
 * 跳转到登录页面
 */

 toLogins:()=>{
   wx.navigateTo({
     url:'/pages/logins/logins'
   })
 },
 
/**
 * 跳转到注册页面
 */

toRegister:()=>{
  wx.navigateTo({
    url:'/pages/register/register'
  })
},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad() {
     this.setData({
      currentActive: 0
     })
     
     var that = this
     wx.request({
       url: that.data.httpurl + 'project/totalFlag',
       success:(res)=>{
         that.setData({
           totalFlag: res.data.data
         })
       }
     })
     wx.request({
      url: that.data.httpurl + 'follow/totalFlag',
      success:(res)=>{
        that.setData({
          totalFollowFlag: res.data.data
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    var that = this;
    wx.getStorage({
      key:'user',
      success (res) {
        that.setData({
          userInfo: res.data,
          flag:false
        })
     }
    })
     wx.getStorage({
       key:"user",
       success:(res)=>{
        wx.request({
          url:that.data.httpurl +'order/getAll',
          data: {
            token: res.data.token
          },
          success:(result)=>{
            if(result.data.code == 0){
              that.setData({
                orders: result.data.data
              })
            }
          }
       })
       }
     })
     wx.request({
      url: that.data.httpurl + 'project/totalFlag',
      success:(res)=>{
        that.setData({
          totalFlag: res.data.data
        })
      }
    })
    wx.request({
      url: that.data.httpurl + 'follow/totalFlag',
      success:(res)=>{
        that.setData({
          totalFollowFlag: res.data.data
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})