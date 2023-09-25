@extends('layouts.base') <!--para heredar de base-->
@section('title', 'Agregar') <!--nombre pagina, nombre de seccion-->
@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-5 mt-5 ml-5">
            <br>
            <br>
            <br>
            <!-- Validacion de Errores -->
            @if($errors->any())
                <div class="alert alert-danger">
                    <ul>
                        @foreach($errors->all() as $error)
                            <li> {{ $error}} </li>
                        @endforeach
                    </ul>
                </div>
            @endif

            <div class="card">
                <form action=" {{ route('zombie.saveZom') }}" method="POST" enctype="multipart/form-data" >
                    @csrf

                    <div class=" card-header text-center" style="background-color: #2A738C">
                        <h2 style="color: #FEFBE7"><i class="fas fa-user-plus"> </i> Registrar</h2>
                    </div>

                    <div class="card-body">
                        <div class="col-lg">
                            <input type="text" class="form-control" value="{{old('email')}}"
                                   placeholder="Correo Electronico" name="email">
                        </div>
                        <br>
                        <div class="col-lg">
                            <input type="text" name="password" class="form-control"
                                   value="{{old('password')}}" placeholder="Contraseña">
                        </div>
                        <br>
                        <div class="col-lg">
                            <input type="text" name="name" class="form-control"
                                   value="{{old('name')}}" placeholder="Nombre de Usuario">
                        </div>
                        <div class="mb-3">
                            <label for="formFile" class="form-label"></label>
                            <input class="form-control" type="file" id="formFile" name="image">
                        </div>
                        <br>
                        <div class="row">
                            <div class="row form-group">
                                <div class="col-md-5 offset-1">
                                    <button id="Guardado" type="submit" class="btn btn-outline-info col-md-12" onclick="save()">
                                        <i class="fas fa-save fa-2x"></i>
                                    </button>
                                </div>
                                <div class="col-md-5">
                                    <a class="btn btn-outline-danger btn-xs col-md-12" href="{{ url('/') }}">
                                        <i class="fas fa-times-circle fa-2x"></i>
                            </a>
                        </div>
                    </div>
                    <br>
                </div>
            </div>
        </form>
    </div>
</div>
@endsection
