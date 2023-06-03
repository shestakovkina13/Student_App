package com.example.studentapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
//базовый класс для фрагмента, упрощает работу с binding
abstract class BaseFragment<Binding : ViewBinding> : Fragment() {
//binding - создаёт экземпляр layout, генерирует код для view
    private var _binding: Binding? = null
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> Binding

    protected val binding: Binding //Private — модификатор доступа, ограничивает видимость данных и методов пределами одного класса.
        get() = _binding as Binding

    override fun onCreateView(
        inflater: LayoutInflater, //пытается присоединить надутые компоненты к корневому элементу (надуваем данными из XML-файла объекты View)
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}