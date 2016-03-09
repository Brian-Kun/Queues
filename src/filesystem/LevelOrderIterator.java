package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import structures.Node;

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
	Node<File> root;
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		// TODO 1
		if(rootNode.exists())
			root = new Node<File>(rootNode);
		else
			throw new FileNotFoundException();
	}
	
	@Override
	public boolean hasNext() {
		// TODO 2
		return false;
	}

	@Override
	public File next() throws NoSuchElementException {
		// TODO 3
		return null;
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
