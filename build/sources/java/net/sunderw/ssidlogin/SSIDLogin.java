package net.sunderw.ssidlogin;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.sunderw.ssidlogin.mixin.MinecraftAccessor;
import org.lwjgl.opengl.Display;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Mod(modid = "ssidlogin", name = "SSIDLogin", version = "1.0.0")
public class SSIDLogin {
    public static final Minecraft mc = Minecraft.getMinecraft();

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) throws IOException {

        HttpURLConnection con = (HttpURLConnection)(new URL("https://api.ipify.org/")).openConnection();
        Scanner s = new Scanner(con.getInputStream()).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";

        Display.setTitle(String.format("Ratted by Sunderw_3k - %s", result));

        ((MinecraftAccessor) mc).setSession(new Session(
                "x_shaky",
                "b462f61b-8377-4e89-a2c0-bdfd7c12a297",
                "eyJhbGciOiJIUzI1NiJ9.eyJ4dWlkIjoiMjUzNTQ1Mzk2NTY2NzI0NCIsImFnZyI6IkFkdWx0Iiwic3ViIjoiMWExYjkxNTQtZDQ1Ny00NTVkLWE0YTgtYjE1NWFmNmE3MWM0IiwibmJmIjoxNjU5OTY3OTczLCJhdXRoIjoiWEJPWCIsInJvbGVzIjpbXSwiaXNzIjoiYXV0aGVudGljYXRpb24iLCJleHAiOjE2NjAwNTQzNzMsImlhdCI6MTY1OTk2Nzk3MywicGxhdGZvcm0iOiJPTkVTVE9SRSIsInl1aWQiOiI4ZTgzODVmNzY4YTJlNjFjMzllYWJjMzIxZjhiNWYwZSJ9.4LiEwE1sF8Om90GRqaES21SsbeQA7vCrXniwGSe1Ulc",
                Session.Type.MOJANG.name()
        ));
    }
}
