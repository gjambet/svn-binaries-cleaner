package net.guillaume.svnbinariescleaner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.util.*;

public class BinaryFinder {

    private File root;
    private Integer minKbSize;
    private List<String> extensions;

    public BinaryFinder(File root) {
        this.root = root;
    }

    @SuppressWarnings("unchecked")
	public Collection<File> getFiles() {
        IOFileFilter filter = new SvnBinaryFileFilter(minKbSize, extensions);
        return FileUtils.listFiles(root, filter, TrueFileFilter.INSTANCE);
    }

    public BinaryFinder withExtensions(String... ext) {
        extensions = Arrays.asList(ext);
        return this;
    }

    public BinaryFinder withMinKbSize(int i) {
        this.minKbSize = i;
        return this;
    }



}
