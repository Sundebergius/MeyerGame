package Meyer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReaderWriterMonitor {
	private int readersCount = 0;
	private int writersCount = 0;

	private int waitingReaders = 0;
	private int waitingWriters = 0;

	private Lock lock = new ReentrantLock();
	private Condition canRead = lock.newCondition();
	private Condition canWrite = lock.newCondition();

	public void beginWrite() throws InterruptedException {
		lock.lock();
		
		if (writersCount == 1 || readersCount > 0) {
			++waitingWriters;
			canWrite.wait();
			--waitingWriters;
		}
	}
	
	public void endWrite() {
		lock.lock();
		writersCount = 0;
		
		if (waitingReaders > 0) {
			canRead.signal();
		} else {
			canWrite.signal();
		}
		lock.unlock();
		
	}
	
	public void beginRead() throws InterruptedException {
		lock.lock();
		
		if (writersCount == 1 || waitingWriters > 1) {
			++waitingReaders;
			canRead.wait();
			--waitingReaders; 
		}
		++readersCount;
		canRead.signal();
		lock.unlock();
	}
	
	public void endRead() {
		lock.lock();
		
		if(--readersCount == 0) {
			canWrite.signal();
		}
		lock.unlock();
	}

}
