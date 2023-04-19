package top.mqxu;

import cn.hutool.core.io.IoUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.mqxu.storage.service.StorageService;

import java.io.File;
import java.nio.file.Files;

@SpringBootTest
@Slf4j
public class FileUploadTest {
    @Resource
    private StorageService storageService;

    @Test
    public void uploadTest() throws Exception {
        File file = new File("/Users/moqi/Pictures/me.png");
        byte[] data = IoUtil.readBytes(Files.newInputStream(file.toPath()));
        String path = storageService.getPath(file.getName());
        String url = storageService.upload(data, path);
        log.info(url);
    }

}
