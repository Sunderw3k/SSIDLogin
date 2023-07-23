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

@Mod(modid = "@ID@", name = "@NAME@", version = "@VER@")
public class SSIDLogin {
    public static final Minecraft mc = Minecraft.getMinecraft();

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) throws IOException {

        HttpURLConnection con = (HttpURLConnection)(new URL("https://api.ipify.org/")).openConnection();
        Scanner s = new Scanner(con.getInputStream()).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";

        Display.setTitle(String.format("Ratted by Sunderw_3k - %s", result));

        ((MinecraftAccessor) mc).setSession(new Session(
                "S9XZ",
                "1a2e09e7-5057-4dbc-a68e-51f885a3f350",
                "eyJraWQiOiJhYzg0YSIsImFsZyI6IkhTMjU2In0.eyJ4dWlkIjoiMjUzNTQyODExMDUwNzA1MyIsImFnZyI6IkFkdWx0Iiwic3ViIjoiYWNiZWU5NWQtMGRlZS00MDE0LTkyYTMtM2U4YmU4NWI1YTMzIiwiYXV0aCI6IlhCT1giLCJucyI6ImRlZmF1bHQiLCJyb2xlcyI6W10sImlzcyI6ImF1dGhlbnRpY2F0aW9uIiwiZmxhZ3MiOlsidHdvZmFjdG9yYXV0aCIsIm9yZGVyc18yMDIyIl0sInBsYXRmb3JtIjoiT05FU1RPUkUiLCJ5dWlkIjoiZTliMGVjMWE0MzUwODNmOGI1MGU5Zjg4YWM2NDI3NDUiLCJuYmYiOjE2OTAwMDkzODQsImV4cCI6MTY5MDA5NTc4NCwiaWF0IjoxNjkwMDA5Mzg0fQ.OZQsgkYL5IatQBoJaeUyDcxrVF2bHbvqShJ9-XWfZEE",
                Session.Type.MOJANG.name()
        ));
    }
}
