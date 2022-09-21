// pages/toNavDetails/toNavDetails.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    httpurl:"http://localhost:82/",
    imageurl:"http://localhost:82/static/",
    navTitle:['推荐','美甲','美容','美发','睫毛'],
    currentActive:0,
    projects:[]
  },

/**
 *接收nav标题的index
 */
navTitleTab:function(e) {
  this.setData({
    currentActive:e.target.dataset.index
  })
  var that = this;
  wx.request({
    url: that.data.httpurl+'project/navTitleType',
    data:{
      proTypeId:e.target.dataset.index
    },
    success:(res)=>{
      console.log(res.data)
      that.setData({
        projects: res.data.data
      })
    }

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
/**
 * 轮播图滑动触发事件
 */
currentChange:function(e){
  console.log(e)
  this.setData({
    currentActive:e.detail.current
  })
  var that = this;
  wx.request({
    url: that.data.httpurl+'project/navTitleType',
    data:{
      proTypeId:e.detail.current
    },
    success:(res)=>{
      console.log(res.data)
      that.setData({
        projects: res.data.data
      })
    }

  })
},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(option) {
    var index = option.id;
    var state;
    switch(index){
      case '5':
        state = 0;
        break;
      case '6':
        state = 1;
        break;
      case '7':
        state = 2;
        break;
      case '8':
        state = 3;
        break;
      case '9':
        state = 4;
        break;
      default:
        state = 0;
        break;
     }
    this.setData({
      currentActive:state
    })

  var that = this;
     
      wx.request({
        url: that.data.httpurl+'project/navTitleType',
        data:{
          proTypeId:state
        },
        success:(res)=>{
          console.log(res.data)
          that.setData({
            projects: res.data.data
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