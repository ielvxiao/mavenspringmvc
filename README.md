# 一些针对sprig mvc的练习

## 之前出现的问题主要是把druid设置在了dispatcher-servlet.xml里了，所以我们要弄明白applicationContext和dispatcher-servlet的区别。

# redis的一些问题
redis通过key去匹配缓存


    @Cacheable(value = "skyCache",key = "#root.target.CACHE_NAME")
    @Override
    public Employee  selectEmployeeById(int id) {
        System.out.println("~~~~~这个应该是没有使用缓存~~~~~~");
        return employeeDao.selectEmployeeById(id);
    }
    @Cacheable(value = "skyCache",key = "#root.target.CACHE_NAME")
    @Override
    public Employee test(int id) {
        System.out.println("这个是测试对比");
        return employeeDao.test(id);
    }
    

上述代码使用相同的sql查询，如果使用相同的key，则会命中缓存。但是Key
这样写还有问题，就是不管我的id是多少，都会返回相同的key，所以我们要
定义一个id，就使用我们的传入参数。

    @Cacheable(value = "skyCache",key = "#root.target.CACHE_NAME")
    public User selectUserById(Integer id) {
        LOGGER.debug("id为{}",id);
        return userDao.selectUserById(id);
    }
添加cacheable后会出现使用aspect的时候命中缓存，则不执行aspect的问题