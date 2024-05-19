/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import jaco.mp3.player.MP3Player;
        

/**
 *
 * @author francisco
 */
public class FuncionesSonidos
{

   private Clip clipWav;    
   private MP3Player sonidoMP3;
    /**
    * Reproduce un .wav
    * @param nombreSonido Nombre del fichero .wav a reproducir 
    * @param tipoSonido 0 para wav 1 para MP3
    */
   
  public FuncionesSonidos(String fichAudio, int tipoAudio)
  {
      if (tipoAudio==0)
      {
       try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fichAudio).getAbsoluteFile());
        clipWav = AudioSystem.getClip();
        clipWav.open(audioInputStream);
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
         //System.out.println("Error al reproducir el sonido.");
        }
      }
      else {
            sonidoMP3=new MP3Player();
            sonidoMP3.addToPlayList(new File(fichAudio));
           }
  }
  
  /**
   * Reproduce el fichero de Audio
   * @param nombreSonido Nombre del fichero de Audio
   */
   
  
  public void reproducirSonidoWav(){
      clipWav.start();
    }
    
  /**
   * Parar el sonido
   */
  public void pararSonidoWav()
  {
   clipWav.stop();
  }

  public void reproducirSonidoMp3(String rutaSonido)
  {
   sonidoMP3.play();
  }
  
  public void pararSonidoMp3()
  {
   sonidoMP3.stop();
  }
  
  public void pausarSonidoMp3()
  {
   sonidoMP3.pause();
  }
  
}
    
    
