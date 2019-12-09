package pro.gravit.launchserver.socket.handlers;

import java.io.File;
import java.nio.file.Files;

public enum ContentType {
	NONE {
		@Override
		public String forPath(File p) {
			return null;
		}
		
	},
	NIO {
		@Override
		public String forPath(File p) {
    		try {
    			return Files.probeContentType(p.toPath());
    		} catch (Throwable e) {
    			return null;
    		}
		}
	};

	public abstract String forPath(File p);
}
