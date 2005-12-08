/**
 * @author Alexey
 */
package com.intellij.lang.properties.editor;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileSystem;
import com.intellij.openapi.vfs.ex.dummy.DummyFileSystem;
import com.intellij.lang.properties.ResourceBundle;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.jetbrains.annotations.NotNull;

public class ResourceBundleAsVirtualFile extends VirtualFile {
  private final ResourceBundle myResourceBundle;

  public ResourceBundleAsVirtualFile(ResourceBundle resourceBundle) {
    myResourceBundle = resourceBundle;
  }

  public ResourceBundle getResourceBundle() {
    return myResourceBundle;
  }

  public Icon getIcon() {
    return ResourceBundle.ICON;
  }

  @NotNull
  public VirtualFileSystem getFileSystem() {
    return DummyFileSystem.getInstance();
  }

  public String getPath() {
    return getName();
  }

  @NotNull
  public String getName() {
    return myResourceBundle.getBaseName();
  }

  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    final ResourceBundleAsVirtualFile resourceBundleAsVirtualFile = (ResourceBundleAsVirtualFile)o;

    if (!myResourceBundle.equals(resourceBundleAsVirtualFile.myResourceBundle)) return false;

    return true;
  }

  public int hashCode() {
    return myResourceBundle.hashCode();
  }

  public void rename(Object requestor, String newName) throws IOException {
  }

  public boolean isWritable() {
    return true;
  }

  public boolean isDirectory() {
    return false;
  }

  public boolean isValid() {
    return true;
  }

  public VirtualFile getParent() {
    return null;
  }

  public VirtualFile[] getChildren() {
    return new VirtualFile[0];
  }

  public VirtualFile createChildDirectory(Object requestor, String name) throws IOException {
    throw new UnsupportedOperationException();
  }

  public VirtualFile createChildData(Object requestor, String name) throws IOException {
    throw new UnsupportedOperationException();
  }

  public void delete(Object requestor) throws IOException {
    //todo
  }

  public void move(Object requestor, VirtualFile newParent) throws IOException {
    //todo
  }

  public InputStream getInputStream() throws IOException {
    throw new UnsupportedOperationException();
  }

  public OutputStream getOutputStream(Object requestor, long newModificationStamp, long newTimeStamp) throws IOException {
    throw new UnsupportedOperationException();
  }

  public byte[] contentsToByteArray() throws IOException {
    throw new UnsupportedOperationException();
  }

  public long getModificationStamp() {
    return 0;
  }

  public long getTimeStamp() {
    return 0;
  }

  public long getLength() {
    return 0;
  }

  public void refresh(boolean asynchronous, boolean recursive, Runnable postRunnable) {

  }
}