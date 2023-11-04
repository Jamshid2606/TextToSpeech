package com.example.texttospeech

import android.speech.tts.TextToSpeech
import com.example.texttospeech.databinding.FragmentFirstBinding
import java.util.Locale

class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {
    lateinit var textToSpeech:TextToSpeech
    override fun onViewCreate() {
        textToSpeech = TextToSpeech(requireContext(), object :TextToSpeech.OnInitListener{
            override fun onInit(p0: Int) {
                if (p0!=TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH)
                }
            }
        })
        binding.btngenerateSpeech.setOnClickListener {
            var text = binding.etText.text.toString()
            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH, null)
        }
    }
}