package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<Character> stack=new Stack<Character>();
		for (int i = 0; i < b.length(); i++) {
			if(b.charAt(i)=='}' && stack.size()==0) {
				stack.push('a');
				break;
			}else
			if(b.charAt(i)=='{') {
				stack.push('{');
			}else if(b.charAt(i)=='}') {
				stack.pop();
			}
		}
		if(stack.size()==0) {
			return true;
		}
		return false;
	}

}