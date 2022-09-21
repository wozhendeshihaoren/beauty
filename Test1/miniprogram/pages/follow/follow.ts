// pages/follow/follow.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    httpurl:"http://localhost:82/",
    imageurl:"http://localhost:82/static/",
    perInformation:['收藏','关注','个人信息'],
    currentActive:0,
    //关注的技师名单
    roster:[],
    conProjects:[],
    user:[]
  },


  /**
   * 
   * @param e 
   */
  currentAction:function(e){
        this.setData({
          currentActive: e.currentTarget.dataset.perindex
        })
       var that = this;
        wx.request({
           url: that.data.httpurl + 'follow/getFollowFlagTrue',
           data:{
             flag: true
           },
           success:(res)=>{
          
             that.setData({
               roster:res.data.data
             })
           }
        })

        /**
         * 收藏项目请求
         * 
         */
        wx.request({
          url: that.data.httpurl + 'project/favItem',
          data:{
            flag: true
          },
          success:(res)=>{
            console.log(res)
            that.setData({
              conProjects: res.data.data
            })
          }
       })

  },

/**
 * 
 * @param e 
 */
currentChange:function(e){
    
    this.setData({
      currentActive:e.detail.current
    })
    
    var that = this;
        wx.request({
           url: that.data.httpurl + 'follow/getFollowFlagTrue',
           data:{
             flag: true
           },
           success:(res)=>{
          
             that.setData({
               roster:res.data.data
             })
           }
        })

        /**
         * 收藏项目请求
         * 
         */
        wx.request({
          url: that.data.httpurl + 'project/favItem',
          data:{
            flag: true
          },
          success:(res)=>{
            console.log(res)
            that.setData({
              conProjects: res.data.data
            })
          }
       })

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(option) {
    var that = this

    console.log(option)
    if(  "0" == option.id){
      this.setData({
        currentActive: 0
      })
    }else if( "1" == option.id) {
      this.setData({
        currentActive: 1
      })
    }else {
      this.setData({
        currentActive: 2
      })
    }
    wx.request({
      url: that.data.httpurl + 'project/favItem',
      data:{
        flag: true
      },
      success:(res)=>{
        console.log(res)
        that.setData({
          conProjects: res.data.data
        })
      }
   })
   wx.getStorage({
     key:'user',
     success:(res)=>{
       console.log(res)
       that.setData({
           user: res.data
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