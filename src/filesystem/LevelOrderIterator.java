package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import structures.Queue;

/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 * 
 * @author liberato
 *
 */
public class LevelOrderIterator extends FileIterator<File> {	
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */
	File root;
	
	Queue<File> fileQueue = new Queue<File>();
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		// TODO 1
		if(rootNode.exists()){
			root = rootNode;
			fileQueue.enqueue(root);
		}else{
			throw new FileNotFoundException("Nothing here, buddie");
		}
	}
	
	@Override
	public boolean hasNext() {
		return !(fileQueue.isEmpty());
	}

	@Override
	public File next() throws NoSuchElementException {
		
		if(!root.exists())
			throw new NoSuchElementException();
		if(hasNext()){
			File answer =  fileQueue.dequeue();
			if(answer.isDirectory()){
				for(File files: answer.listFiles()){
					fileQueue.enqueue(files);
				}
			}
			return answer;
		}else{
			throw new NoSuchElementException("Nothing here, buddie");
		}
	}

	@Override
	public void remove() {
		// Leave this one alone. Okay!
		throw new UnsupportedOperationException();		
	}

}
