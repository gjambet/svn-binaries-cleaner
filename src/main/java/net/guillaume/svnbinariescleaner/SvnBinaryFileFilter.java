package net.guillaume.svnbinariescleaner;

import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.File;
import java.util.List;

public class SvnBinaryFileFilter implements IOFileFilter {

    private final Integer minKbSize;
    private final List<String> extensions;

    public SvnBinaryFileFilter(Integer minKbSize, List<String> extensions) {
        this.minKbSize = minKbSize;
        this.extensions = extensions;
    }

    @Override
    public boolean accept(File file) {
        return doAccept(file);
    }
    @Override
    public boolean accept(File file, String s) {
        return doAccept(file);
    }

    private boolean doAccept(File file) {

        if (file.getAbsolutePath().contains(".svn")) {
            return false;
        }

        boolean accepted = true ;

        if (minKbSize != null) {
            accepted &= (file.length() > (minKbSize * 1024));
        }

        if (extensions != null) {
            boolean matching = false;
            for (String ext : extensions) {
                matching |= file.getName().toLowerCase().endsWith(ext.toLowerCase());
            }
            accepted &= matching;
        }

        return accepted;
    }

}
