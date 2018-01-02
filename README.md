# glaaery
图片浏览


喜欢画画，所以建了个显示我涂鸦的网站，由于服务器较渣，还好死不死地把图片都放到了服务器上，所以一个分页只显示两张图片，需要更改则在src/Dao/Dao.java里更改：
```java
public List<ImgEntity> getpage(int pageNo)
    {
        List<ImgEntity> rtn = new ArrayList<>();
        Query query = se.createQuery("from ImgEntity");
        int pageSize = 2; //这里的2改为你想要一也显示的图片数量
        rtn = query.setFirstResult((pageNo-1)*pageSize)
                .setMaxResults(pageSize)
                .list();
        destory();
        return rtn;
    }
```
  下面的获取图片数量的方法也要更改：
```java
    public int getpagesum(){
        String hql= "select count(*) from ImgEntity";
        Query query=se.createQuery(hql);
        int page = ((Long) query.iterate().next()).intValue();
        return page/2+((page%2)>0?1:0); //这里的公式要改一下，具体自己斟酌，这里会返回一个最后一张图片所在的页数，总图片数除2（每页的数量），如果有余数是1则再加一页。
    }
```
用了struts2和hibernate框架（边学边做）

没有用maven创建工程，用的是IDEA自动生成的框架基本的lib，没有添加其他的。

有上传和浏览功能，主页是最新上传图片的尾面。

（7/21）更新了删除图片功能，主页图片会显示图片序号，输入序号可删除相应的图片，但仅仅是删除数据库里的记录，虽然以后不会再加载删除掉的图片，但图片文件还是会存。删除页面需要手动输入地址，主页并没有跳转链接。
发现上传时如果文件同名的bug，新增了上传文件重命名功能。
