package test.com.sface.iredis.config; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;


/**
 * @className RedisConfigTest
 * @description 要先安装redis，启动redis服务端：
 * 启动一个cmd接口，cd redis安装目录
 * 运行 redis-server.exe redis.windows.conf
 *
 * 直接通过redis-cli客户端测试：
 * 另启动一个cmd端口,cd redis安装目录（配置了系统环境变量则无需cd到安装目录）
 * 运行 redis-cli.exe -h 127.0.0.1 -p 6379
 * @author HZ
 * @date 2018年10月3日 下午9:46:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisConfigTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * @title testStr
     * @description 测试手动缓存字符串
     * @date 2018年10月3日 下午10:21:25
     * @author BSmile
     * @throws Exception
     */
    @Test
    public void testManualStr() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    /**
     * @title testManualObj
     * @description 测试手动缓存对象
     * @date 2018年10月3日 下午10:21:23
     * @author BSmile
     * @throws Exception
     */
    @Test
    public void testManualObj() throws Exception {
        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user, 2, TimeUnit.SECONDS);//由于设置的是2秒失效，2秒之内查询有结果，2秒之后返回为null
        Thread.sleep(2000);
        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists) {
            System.out.println("exists is true");
            Assert.assertEquals("aa@126.com", operations.get("com.neo.f").getUserName());
        } else {
            System.out.println("exists is false");
        }
    }
}