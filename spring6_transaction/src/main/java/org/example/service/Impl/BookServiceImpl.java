package org.example.service.Impl;

import org.example.dao.BookDao;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    /*
    默认不设置为只读
    设置超时时间，默认为-1一直运行（在当前时间内如果没执行完，则会强制回滚，释放资源并抛出异常，单位为毫秒）
    rollbackFor属性：需要设置一个Class类型的对象
    rollbackForClassName属性：需要设置一个字符串类型的全类名
    noRollbackFor属性：需要设置一个Class类型的对象
    rollbackFor属性：需要设置一个字符串类型的全类名
    */
    /*
    @Transactional(readOnly = false)
    @Transactional(timeout = -1)
    @Transactional(noRollbackFor = ArithmeticException.class)
    @Transactional(noRollbackForClassName = "java.lang.ArithmeticException")
    */
    /*
    读未提交：READ UNCOMMITTED
    允许Transaction01读取Transaction02未提交的修改。----->脏读、不可重复读、幻读
    读已提交：READ COMMITTED、
    要求Transaction01只能读取Transaction02已提交的修改。----->不可重复读、幻读
    可重复读：REPEATABLE READ
    确保Transaction01可以多次从一个字段中读取到相同的值，即Transaction01执行期间禁止其它
    事务对这个字段进行更新。----->幻读
    串行化：SERIALIZABLE
    确保Transaction01可以多次从一个表中读取到相同的行，在Transaction01执行期间，禁止其它
    事务对这个表进行添加、更新、删除操作。可以避免任何并发问题，但性能十分低下。
    */
    /*
    @Transactional(isolation = Isolation.DEFAULT)//使用数据库默认的隔离级别
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)//读未提交
    @Transactional(isolation = Isolation.READ_COMMITTED)//读已提交
    @Transactional(isolation = Isolation.REPEATABLE_READ)//可重复读
    @Transactional(isolation = Isolation.SERIALIZABLE)//串行化
    */
    /*
    1、PROPAGATION_REQUIRED：支持当前事务，如果不存在就新建一个(默认) ；
    2、PROPAGATION_REQUIRES_NEW：开启一个新的事务，如果一个事务已经存在，则将这个存在的事务挂起；
    3、PROPAGATION_SUPPORTS：支持当前事务，如果当前没有事务，就以非事务方式执行。
    4、PROPAGATION_NOT_SUPPORTED：以非事务方式运行，如果有事务存在，挂起当前事务；
    5、PROPAGATION_MANDATORY：必须运行在一个事务中，如果当前没有事务正在发生，将抛出一个异常；
    6、PROPAGATION_NEVER：以非事务方式运行，如果有事务存在，抛出异常；
    7、PROPAGATION_NESTED：如果当前正有一个事务在进行中，则该方法应当运行在一个嵌套式事务中。
    被嵌套的事务可以独立于封装事务进行提交或回滚。如果封装事务不存在，行为就像PROPAGATION_REQUIRES一样。
    */
    /*@Transactional(propagation = Propagation.REQUIRED)*/
    @Transactional
    public void buyBook(Integer userId, Integer bookId) {
        //查询图书的价格
        Integer price=bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId,price);
    }
}
