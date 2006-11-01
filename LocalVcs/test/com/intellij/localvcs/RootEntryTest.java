package com.intellij.localvcs;

import org.junit.Before;
import org.junit.Test;

public class RootEntryTest extends TestCase {
  private RootEntry root;
  private Entry child;

  @Before
  public void setUp() {
    root = new RootEntry();
    child = new DirectoryEntry(1, "child");
    root.addChild(child);
  }

  @Test
  public void testPathToChildren() {
    assertSame(root, child.getParent());
    assertEquals(p("child"), child.getPath());
  }

  @Test
  public void testFindingChildren() {
    assertSame(child, child.findEntry(p("child")));
  }

  @Test
  public void testCopying() {
    Entry copy = root.copy();

    assertEquals(RootEntry.class, copy.getClass());
    assertEquals(1, copy.getChildren().size());

    assertNotSame(child, copy.getChildren().get(0));
    assertEquals("child", copy.getChildren().get(0).getName());
  }
}
